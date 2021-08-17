package Polymorphism.Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public abstract double calculatePerimeter();
    public abstract double calculateArea();
}
