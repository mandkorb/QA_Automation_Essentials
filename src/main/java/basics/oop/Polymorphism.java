package basics.oop;

// Parent class
class Shape {
    // Method to calculate area (to be overridden by child classes)
    public void calculateArea() {
        System.out.println("Calculating area for a generic shape...");
    }
}

// Child class for Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle is: " + area);
    }
}

// Child class for Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        double area = length * width;
        System.out.println("The area of the rectangle is: " + area);
    }
}

// Child class for Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void calculateArea() {
        double area = 0.5 * base * height;
        System.out.println("The area of the triangle is: " + area);
    }
}

// Main class to demonstrate polymorphism
public class Polymorphism {
    public static void main(String[] args) {
        // Creating objects for different shapes
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 7);

        // Demonstrating polymorphism
        System.out.println("Polymorphism in action:");
        circle.calculateArea(); // Calls Circle's calculateArea method
        rectangle.calculateArea(); // Calls Rectangle's calculateArea method
        triangle.calculateArea(); // Calls Triangle's calculateArea method
    }
}
