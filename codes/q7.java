/*
 * Q07: Interface and Multiple Implementation Classes
 * Question: Define a Java interface Payable and implement it across multiple distinct classes to demonstrate contract-driven programming.
 */

// Interface defines a contract (methods are implicitly public and abstract)
interface Payable {
    double calculatePayment();
    String getPaymentDetails();
}

// First implementation: salaried full-time employee
class FullTimeEmployee implements Payable {
    private String empId;
    private double monthlySalary;

    public FullTimeEmployee(String empId, double monthlySalary) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment() {
        return monthlySalary;
    }

    @Override
    public String getPaymentDetails() {
        return "Full-Time Salary for " + empId;
    }
}

// Second implementation: hourly-paid contractor
class Contractor implements Payable {
    private String contractorId;
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(String contractorId, double hourlyRate, int hoursWorked) {
        this.contractorId = contractorId;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getPaymentDetails() {
        return "Contract Payment (" + hoursWorked + " hrs) for " + contractorId;
    }
}

public class q7 {
    public static void main(String[] args) {
        // Both objects are accessed uniformly through the Payable interface
        Payable p1 = new FullTimeEmployee("FTE-99", 65000.0);
        Payable p2 = new Contractor("CON-404", 45.0, 160);

        System.out.println(p1.getPaymentDetails() + " -> $" + p1.calculatePayment());
        System.out.println(p2.getPaymentDetails() + " -> $" + p2.calculatePayment());
    }
}
