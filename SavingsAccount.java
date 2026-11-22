/* Programmed by Anthony Ellinos
   Assignment: Project 1
   Savings account class */

public class SavingsAccount {
    private double balance;
    private double annualInterestRate;

    // savings account constructor
    public SavingsAccount(double bal) {
        balance = bal;
    }

    // Interest rate getter
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Balance getter
    public double getBalance() {
        return balance;
    }

    // interest rate setter
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    public double addMonthlyInterestRate() {
        double addMonthlyInterestRate = balance * (annualInterestRate / 12);
        balance += addMonthlyInterestRate;
        return addMonthlyInterestRate;
    }
}
