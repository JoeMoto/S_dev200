package Mod2PA3;

import java.util.Scanner;

public class bin2DecTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binaryString = input.nextLine();

        try {
            int decimalValue = assign12_9.bin2Dec(binaryString);
            System.out.println("The decimal value for binary string " + binaryString + " is " + decimalValue);
        } catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }

        input.close();
    }
}
