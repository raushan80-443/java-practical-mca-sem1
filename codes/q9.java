/*
 * Q09: User-Defined Exception Using throw and throws
 * Question: Construct a custom exception class InsufficientFundsException and throw it based on custom domain constraints using throw and throws.
 */

// Custom checked exception (extends Exception)
class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        // Pass descriptive message to Exception superclass
        super("Insufficient funds! Shortage of $" + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 'throws' declares that callers must handle or re-declare InsufficientFundsException
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double needs = amount - balance;
            // 'throw' explicitly raises the custom exception object
            throw new InsufficientFundsException(needs);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: $" + balance);
    }
}

public class q9 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);

        try {
            System.out.println("Attempting to withdraw $200.00...");
            account.withdraw(200.00); // Succeeds (balance becomes $300)

            System.out.println("Attempting to withdraw $400.00...");
            account.withdraw(400.00); // Throws InsufficientFundsException ($100 short)
        } catch (InsufficientFundsException e) {
            System.err.println("Transaction Failed: " + e.getMessage());
        }
    }
}
