package com.basics.demo;

public class DataTypes {
    // Initialize all data types
    byte byteValue = 127; // 1 byte, value from -128 to 127
    short shortValue = 32000; // 2 bytes, values from -32,768 to 32,767
    int intValue = 100; // 4 bytes, values from -2,147,483,648 to 2,147,483,647
    long longValue = 10000000000L; // 8 bytes, values from -2^63 to 2^63-1
    float floatValue = 3.14f; // 4 bytes, accuracy up to 7 decimal places
    double doubleValue = 3.14159265359; // 8 bytes, accuracy up to 16 decimal places
    char charValue = 'A'; // 2 bytes, values: Unicode symbols from '\u0000' to '\uffff'
    boolean booleanValue = true; // 1 byte, values: true or false
    String stringValue = "Hello, Java!"; // A class that represents strings

    // Method for performing operations on data types and displaying the results in the console
    public void performOperations() {
        System.out.println("Операції з типами даних:");

        // Arithmetic operations
        System.out.println(intValue + " + 5 = " + (intValue + 5)); // Addition
        System.out.println(intValue + " - 10 = " + (intValue - 10)); // Subtraction
        System.out.println(intValue + " * 2 = " + (intValue * 2)); // Multiplication
        System.out.println(intValue + " / 3 = " + (intValue / 3)); // Division
        System.out.println(intValue + " % 3 = " + (intValue % 3)); // Remainder of division (for example, 10% 3 = 1)

        // Household operations
        System.out.println(byteValue + " << 1 = " + (byteValue << 1)); // Left shift
        System.out.println(byteValue + " >> 1 = " + (byteValue >> 1)); // Right shift

        // Operations with char
        System.out.println(charValue + " + 1 = " + (char) (charValue + 1)); // Next Unicode symbol

        // Operations with boolean
        System.out.println(booleanValue + " && false = " + (booleanValue && false)); // Logical AND
        System.out.println(booleanValue + " || false = " + (booleanValue || false)); // Logical OR
        System.out.println("!" + booleanValue + " = " + !booleanValue); // Denying

        // Comparison operators
        System.out.println(byteValue + " < " + intValue + " = " + (byteValue < intValue));
        System.out.println(byteValue + " >= " + intValue + " = " + (byteValue >= intValue));
        System.out.println(byteValue + " != " + intValue + " = " + (byteValue != intValue));
        System.out.println(byteValue + " == " + byteValue + " = " + (byteValue == byteValue));
    }

    public static void main(String[] args) {
        // Creating DataTypesDemo object
        DataTypes dataTypes = new DataTypes();

        // Calling a method to demonstrate operations
        dataTypes.performOperations();
    }
}
