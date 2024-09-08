package Mod3PA1;

public class assign13_9 {
    public static void main(String[] args) {
        Circle redCircle = new Circle(5, "red", true);
        Circle greenCircle = new Circle(5, "green", false);
        Circle smallerGreenCircle = new Circle(4, "green", false);

        System.out.println("Red Circle radius: " + redCircle.getRadius());
        System.out.println("Green Circle radius: " + greenCircle.getRadius());
        System.out.println("Smaller Green Circle radius: " + smallerGreenCircle.getRadius());

        System.out.println("Red Circle is " + (redCircle.equals(greenCircle) ? "" : "not ") + "equal to Green Circle");
        System.out.println("Red Circle is " + (redCircle.equals(smallerGreenCircle) ? "" : "not ")
                + "equal to Smaller Green Circle");

    }
}