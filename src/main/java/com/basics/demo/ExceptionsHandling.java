package com.basics.demo;

public class ExceptionsHandling {
    // Method to demonstrate a try-catch block
    public void demonstrateTryCatch() {
        System.out.println("Demonstrating try-catch:");
        try {
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: Division by zero is not allowed.");
        }
    }

    // Method to demonstrate a try-catch-finally block
    public void demonstrateTryCatchFinally() {
        System.out.println("\nDemonstrating try-catch-finally:");
        try {
            String text = null;
            System.out.println(text.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Attempted to access a null object.");
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    // Method to demonstrate throwing a custom exception
    public void demonstrateCustomException() throws CustomException {
        System.out.println("\nDemonstrating custom exception:");
        throw new CustomException("This is a custom exception message.");
    }

    // Main method to demonstrate exception handling
    public static void main(String[] args) {
        ExceptionsHandling demo = new ExceptionsHandling();

        // Demonstrating try-catch
        demo.demonstrateTryCatch();

        // Demonstrating try-catch-finally
        demo.demonstrateTryCatchFinally();

        // Demonstrating custom exception
        try {
            demo.demonstrateCustomException();
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }
}

// Custom exception class
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
