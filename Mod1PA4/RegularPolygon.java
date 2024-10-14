package Mod1PA4;

public class RegularPolygon {
    // Private data fields
    private int n = 3; // Number of sides, default is 3
    private double side = 1; // Length of each side, default is 1
    private double x = 0; // x-coordinate of the center, default is 0
    private double y = 0; // y-coordinate of the center, default is 0

    // No-arg constructor
    public RegularPolygon() {
    }

    // Constructor with specified number of sides and length of side, centered at
    // (0, 0)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // Constructor with specified number of sides, length of side, and x- and
    // y-coordinates
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Accessor and mutator methods for all data fields
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Method to calculate the perimeter of the polygon
    public double getPerimeter() {
        return n * side;
    }

    // Method to calculate the area of the polygon
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}
