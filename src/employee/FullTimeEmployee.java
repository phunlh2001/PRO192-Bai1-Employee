package employee;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class FullTimeEmployee extends Employee implements Serializable {
    private int workInDays;

    public int getWorkInDays() {
        return workInDays;
    }

    public void setWorkInDays(int workInDays) {
        this.workInDays = workInDays;
    }

    @Override
    protected double calculateSalary() {
        return this.salary * this.workInDays * 24;
    }
    
    @Override
    protected void display() {
        System.out.println("- ID: " + this.getId());
        System.out.println("- Name: " + this.getName());
        System.out.println("- Age: " + this.getAge());
        System.out.println("- Total Salary: " + this.calculateSalary());
        System.out.println("- Working days: " + this.getWorkInDays());
    }
}
