package com.basics.demo.oop;

// A class to demonstrate basic concepts of classes and objects
public class Encapsulation {

    // Fields (Instance variables)
    private String name;
    private int age;

    // Constructor to initialize fields
    public Encapsulation(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Method to display the details of the object
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method to demonstrate classes and objects
    public static void main(String[] args) {
        // Creating objects of the class
        Encapsulation person1 = new Encapsulation("Alice", 25);
        Encapsulation person2 = new Encapsulation("Bob", 30);

        // Displaying details of person1
        System.out.println("Person 1 Details:");
        person1.displayDetails();

        // Modifying and displaying details of person2
        System.out.println("\nPerson 2 Details:");
        person2.setName("Charlie");
        person2.setAge(35);
        person2.displayDetails();

        // Accessing fields using getters
        System.out.println("\nAccessing fields via getters:");
        System.out.println("Person 1 Name: " + person1.getName());
        System.out.println("Person 1 Age: " + person1.getAge());
    }
}