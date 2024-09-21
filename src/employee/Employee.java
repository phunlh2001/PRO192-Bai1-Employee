package employee;

import java.io.Serializable;

/**
 *
 * @author Asus
 * Base class
 */
public abstract class Employee implements Serializable {
    private int id;
    private String name;
    private int age;
    protected double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    protected abstract double calculateSalary();
    protected abstract void display();
}
