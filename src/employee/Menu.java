package employee;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Menu {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("--- Employee Management ---");
            System.out.println("1. Add fulltime employee");
            System.out.println("2. Add parttime employee");
            System.out.println("3. Show all employees");
            System.out.println("4. Delete all.");
            System.out.println("5. Exit");

            try {
                System.out.print("Your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        manager.addFullTimeEmployee();
                        break;
                    case 2:
                        manager.addPartTimeEmployee();
                        break;
                    case 3:
                        manager.showEmployees();
                        break;
                    case 4:
                        manager.deleteAll();
                        break;
                    case 5:
                        System.out.println("Exitting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Only accept numeric choice");
                sc.next();
            } catch (InvalidSalaryException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        } while (choice != 5);
    }
}
