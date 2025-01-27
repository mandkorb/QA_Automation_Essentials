package language_basics.oop;

// Base class (Parent class)
class Animal {
    // Field to store the name of the animal
    private String name;

    // Constructor to initialize the name
    public Animal(String name) {
        this.name = name;
    }

    // Method to display the sound of the animal
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    public Animal setName(String name) { // Used for multi object calling
        this.name = name;
        return this;
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Method to display details of the animal
    public void displayDetails() {
        System.out.println("Animal Name: " + name);
    }
}

// Derived class (Child class)
class Dog extends Animal {
    // Constructor for Dog, calling the parent class constructor
    public Dog(String name) {
        super(name); // Calls the constructor of the parent class
    }

    @Override
    public Dog setName(String name) { // Used for multi object calling
        super.setName(name);
        return this;
    }

    // Overriding the makeSound method
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Another derived class (Child class)
class Cat extends Animal {
    // Constructor for Cat, calling the parent class constructor
    public Cat(String name) {
        super(name); // Calls the constructor of the parent class
    }

    // Overriding the makeSound method
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

// Main class to demonstrate inheritance
public class Inheritance {
    public static void main(String[] args) {
        // Creating objects of the child classes
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");

        // Displaying details and sounds of each animal
        System.out.println("Dog Details:");
        dog.displayDetails();
        dog.makeSound();

        System.out.println("\nCat Details:");
        cat.displayDetails();
        cat.makeSound();

        // Demonstrating polymorphism
        System.out.println("\nPolymorphism Example:");
        Animal animal = new Dog("Max");
        animal.makeSound(); // Calls Dog's overridden method
        animal = new Cat("Luna");
        animal.makeSound(); // Calls Cat's overridden method
    }
}
