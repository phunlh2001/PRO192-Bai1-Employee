package employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Asus
 * Java core -> syntax java 6
 */
public class EmployeeManager {

    List<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public final String FILE_PATH = "employees.txt";

    public void addFullTimeEmployee() throws InvalidSalaryException, IOException {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        if (salary <= 0) {
            throw new InvalidSalaryException("Salary must greater than zero.");
        }
        System.out.print("Enter number of workdays: ");
        int workDays = Integer.parseInt(sc.nextLine());
        
        FullTimeEmployee emp = new FullTimeEmployee();
        emp.setId(id);
        emp.setAge(age);
        emp.setName(name);
        emp.setSalary(salary);
        emp.setWorkInDays(workDays);
        employees.add(emp);
        saveToFile();
    }

    public void addPartTimeEmployee() throws InvalidSalaryException, IOException {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        if (salary <= 0) {
            throw new InvalidSalaryException("Salary must greater than zero.");
        }
        System.out.print("Enter number of work hours: ");
        int workHours = Integer.parseInt(sc.nextLine());

        PartTimeEmployee emp = new PartTimeEmployee();
        emp.setId(id);
        emp.setAge(age);
        emp.setName(name);
        emp.setSalary(salary);
        emp.setWorkPerHours(workHours);
        employees.add(emp);
        saveToFile();
    }

    public void showEmployees() throws IOException, ClassNotFoundException {
        loadFromFile();
        if (employees.isEmpty()) {
            // if employees.size() == 0
            System.out.println("The employee list is empty.");
        } else {
            System.out.println("----------- Employee Information -----------");
            for (Employee empl : employees) {
                empl.display();
                System.out.println("----------- #### -----------");
            }
        }
    }
    
    public void deleteAll() {
        try {
            employees.removeAll(employees);
            saveToFile();
            System.out.println("Delete all data success");
        } catch (IOException e) {
            System.out.println("Failed to delete data: " + e.getMessage());
        }
    }

    private void saveToFile() throws IOException {
        ObjectOutputStream oos = null;
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                // if (file == false)
                file.createNewFile();
                System.out.println("Created new file.");
            }
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            // foreach
            for (Employee emp : employees) {
                oos.writeObject(emp);
            }
            System.out.println("Added file success.");
        } catch (IOException e) {
            System.out.println("Failed to save file: " + e.getMessage());
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    private void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created new file.");
            }

            FileInputStream fis = new FileInputStream(file);
            // fis == content bên trong file
            ois = new ObjectInputStream(fis);
            employees.removeAll(employees);
            while (fis.available() > 0) {
                // fis (content file) = -1
                Employee emp = (Employee) ois.readObject();
                employees.add(0, emp);
            }
            System.out.println("Loaded file successful!");
        } catch (IOException e) {
            System.out.println("Failed to load file: " + e.getMessage());
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
