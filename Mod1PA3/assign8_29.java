package Mod1PA3;

import java.util.Scanner;

public class assign8_29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter first array of integers: ");
        int[][] m1 = new int[3][3];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = input.nextInt();
            }
        }

        System.out.print("Please enter second array of integers: ");
        int[][] m2 = new int[3][3];

        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] = input.nextInt();
            }
        }

        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }

        input.close();
    }

    public static boolean equals(int[][] m1, int[][] m2) {

        if (m1.length != m2.length) {
            return false;
        }

        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }

            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
