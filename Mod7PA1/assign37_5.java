package Mod7PA1;

import java.util.Scanner;

public class assign37_5 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Prompt the user for loan details
        System.out.print("Enter loan amount: ");
        double loanAmount = input.nextDouble();

        System.out.print("Enter annual interest rate (e.g., 5.5): ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        // Create a Loan object with the provided details
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Calculate monthly and total payments
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        // Display the results
        System.out.printf("The monthly payment is: %.2f\n", monthlyPayment);
        System.out.printf("The total payment is: %.2f\n", totalPayment);

        // Close the scanner
        input.close();
    }
}
