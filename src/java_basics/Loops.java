package java_basics;

public class Loops {
    // Method to demonstrate the 'for' loop
    public void forLoopDemo() {
        System.out.println("Demonstration of 'for' loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }

    // Method to demonstrate the 'while' loop
    public void whileLoopDemo() {
        System.out.println("\nDemonstration of 'while' loop:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
    }

    // Method to demonstrate the 'do-while' loop
    public void doWhileLoopDemo() {
        System.out.println("\nDemonstration of 'do-while' loop:");
        int number = 1;
        do {
            System.out.println("Number: " + number);
            number++;
        } while (number <= 5);
    }

    // Method to demonstrate the 'for-each' loop
    public void forEachLoopDemo() {
        System.out.println("\nDemonstration of 'for-each' loop:");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
    }

    // Method to demonstrate breaking out of a loop
    public void breakDemo() {
        System.out.println("\nDemonstration of 'break' keyword:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Breaking the loop at i = " + i);
                break;
            }
            System.out.println("i = " + i);
        }
    }

    // Method to demonstrate continuing a loop
    public void continueDemo() {
        System.out.println("\nDemonstration of 'continue' keyword:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.println("Odd number: " + i);
        }
    }

    // Main method for demonstrating loops
    public static void main(String[] args) {
        // Create an object of LoopsDemo
        Loops demo = new Loops();

        // Call the methods to demonstrate different loops
        demo.forLoopDemo();
        demo.whileLoopDemo();
        demo.doWhileLoopDemo();
        demo.forEachLoopDemo();
        demo.breakDemo();
        demo.continueDemo();
    }
}
