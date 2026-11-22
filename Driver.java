/* Programmed by Anthony Ellinos
   Assignment: Project 1
   Savings Account */

import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        // creation of keyboard
        Scanner keyboard = new Scanner(System.in);
        // ask the user for starting balance
        System.out.print("Hello user, please enter your starting balance : ");

        double startBal = keyboard.nextDouble();
        while (startBal <= 0) {
            System.out.println("Starting balance must be greater than 0");
            System.out.print("Enter your starting balance: ");
            startBal = keyboard.nextDouble();
        }

        // store the users balance in savings account
        SavingsAccount account = new SavingsAccount(startBal);
        System.out.print("Now please enter your annual interest rate in decimal form(0.1 for 10%): ");
        double rate = keyboard.nextDouble();

        // while loops checks if between 0 and 1
        while (rate <= 0 || rate > 1) {
            System.out.println("The interest rate must be between 0 and 1.");
            System.out.print("Re-enter your annual interest rate: ");
            rate = keyboard.nextDouble();
        }
        // setting the interest rate
        account.setAnnualInterestRate(rate);
        System.out.print("How many months have passed?: ");
        int months = keyboard.nextInt();

        // while loops checks for both conditions...if negative or zero
        while (months <= 0) {
            System.out.println("Months must be greater than 0.");
            System.out.print("How many months have passed?: ");
            months = keyboard.nextInt();
        }

        // totals initialized before loop
        double totalDeposited = 0;
        double totalWithdrawn = 0;
        double totalInterestEarned = 0;

        for (int count = 0; count < months; count++) {
            System.out.print("Enter the amount deposited during month " + (count + 1) + ": ");
            double depo = keyboard.nextDouble();

            while (depo <= 0) {
                System.out.println("Deposit amount must be greater than 0.");
                System.out.print("Enter the amount deposited during month " + (count + 1) + ": ");
                depo = keyboard.nextDouble();
            }
            account.deposit(depo);
            totalDeposited += depo;

            System.out.print("Enter the amount withdrawn during month " + (count + 1) + ": ");
            double withdr = keyboard.nextDouble();
            while (withdr <= 0) {
                System.out.println("Withdrawn amount must be greater than 0.");
                System.out.print("Enter the amount withdrawn during month " + (count + 1) + ": ");
                withdr = keyboard.nextDouble();
            }
            account.withdrawal(withdr);
            totalWithdrawn += withdr;
            // add this month's interest to the balance and to the running interest total
            totalInterestEarned += account.addMonthlyInterestRate();
        }
        // final output
        System.out.println("Total deposited: " + totalDeposited);
        System.out.println("Total withdrawn: " + totalWithdrawn);
        System.out.println("Total interest earned: " + String.format("%.2f", totalInterestEarned));
        System.out.println("Ending balance: " + String.format("%.2f", account.getBalance()));
        // closing keyboard scanner...not sure if needed
        keyboard.close();
    }
}
