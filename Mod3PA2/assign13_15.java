package Mod3PA2;

import java.math.BigInteger;
import java.util.Scanner;

public class assign13_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two rational numbers
        System.out.print("Enter the first rational number (numerator and denominator): ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger den1 = input.nextBigInteger();

        System.out.print("Enter the second rational number (numerator and denominator): ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger den2 = input.nextBigInteger();

        // Create rational objects
        rational r1 = new rational(num1, den1);
        rational r2 = new rational(num2, den2);

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());

        input.close();
    }
}
