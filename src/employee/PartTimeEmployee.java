package employee;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class PartTimeEmployee extends Employee implements Serializable {
    private int workPerHours;

    public int getWorkPerHours() {
        return workPerHours;
    }

    public void setWorkPerHours(int workPerHours) {
        this.workPerHours = workPerHours;
    }
    
    @Override
    protected double calculateSalary() {
        return this.salary * this.workPerHours;
    }

    @Override
    protected void display() {
        System.out.println("- ID: " + this.getId());
        System.out.println("- Name: " + this.getName());
        System.out.println("- Age: " + this.getAge());
        System.out.println("- Total Salary: " + this.calculateSalary());
        System.out.println("- Working hours: " + this.getWorkPerHours());
    }
    
}
