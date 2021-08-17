package Polymorphism.Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * width) + (2 * height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
