package java_basics.oop;

// Abstract class
abstract class Vehicle {
    // Abstract method (must be implemented by subclasses)
    public abstract void move();

    // Concrete method (common for all subclasses)
    public void stop() {
        System.out.println("The vehicle has stopped.");
    }
}

// Concrete subclass for Car
class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("The car drives on the road.");
    }
}

// Concrete subclass for Boat
class Boat extends Vehicle {
    @Override
    public void move() {
        System.out.println("The boat sails on water.");
    }
}

// Main class to demonstrate abstraction
public class Abstractions {
    public static void main(String[] args) {
        // Creating objects for Car and Boat
        Vehicle car = new Car();
        Vehicle boat = new Boat();

        // Demonstrating abstract method implementation
        System.out.println("Abstract method demonstration:");
        car.move(); // Calls Car's move method
        boat.move(); // Calls Boat's move method

        // Demonstrating concrete method from abstract class
        System.out.println("\nConcrete method demonstration:");
        car.stop();
        boat.stop();
    }
}
