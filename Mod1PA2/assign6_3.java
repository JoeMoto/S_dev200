package Mod1PA2;

import java.util.Scanner;

public class assign6_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter an integer: ");

        int num = input.nextInt();
        boolean isPal = isPalindrome(num);
        if (isPal == true) {
            System.out.println(num + " is a Palindrome");
        } else if (isPal == false) {
            System.out.println(num + " is not a Palindrome");
        }

        input.close();
    }

    // Return the reversal of an integer, e.g., reverse(456) returns 654
    public static int reverse(int number) {
        int reverse = 0;
        int integer;

        while (number != 0) {
            integer = number % 10;
            reverse = reverse * 10 + integer;
            number = number / 10;
        }

        return reverse;
    }

    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {

        int reversedNum = reverse(number);
        if (reversedNum == number) {
            return true;
        } else {
            return false;
        }
    }
}
