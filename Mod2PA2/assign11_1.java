package Mod2PA2;

import java.util.Scanner;

public class assign11_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user to input the three sides of the triangle
        System.out.print("Enter three side of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        // Ask the user to input a color
        System.out.print("Enter a color: ");
        String color = input.next();

        // Ask the user to specify whether the triangle is filled
        System.out.print("Is the triangle filled (true / false)? ");
        boolean filled = input.nextBoolean();

        // Construct a Triangle object with the user's input
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println(triangle.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Triangle is" + (triangle.isFilled() ? "" : " not ")
                + "filled");

        input.close();
    }
}
