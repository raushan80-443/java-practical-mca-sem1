/*
 * Q05: Method Overriding Using Inheritance and super
 * Question: Illustrate method overriding, runtime polymorphism, and invocation of superclass constructors and methods using the 'super' keyword.
 */

// Superclass (Parent class)
class Person {
    // 'protected' allows subclasses (like Employee) to access these fields directly
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass (Child class) inheriting from Person
class Employee extends Person {
    private String employeeId;
    private double salary;

    public Employee(String name, int age, String employeeId, double salary) {
        super(name, age); // Must be first statement: calls Person(name, age) constructor
        this.employeeId = employeeId;
        this.salary = salary;
    }

    // Overrides Person.displayInfo() to include Employee-specific details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calls parent's displayInfo() first
        System.out.println("Employee ID: " + employeeId + ", Salary: $" + salary);
    }
}

public class q5 {
    public static void main(String[] args) {
        // Runtime polymorphism: Person reference pointing to an Employee object
        Person emp = new Employee("Alice Johnson", 29, "EMP-1024", 75000.00);
        emp.displayInfo(); // Calls Employee's overridden displayInfo() at runtime
    }
}
