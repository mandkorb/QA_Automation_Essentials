package java_basics;

public class Strings {
    // Method to demonstrate common string operations
    public void stringOperations() {
        String str = "Hello, Java!";
        System.out.println("Original String: " + str);

        // Getting the length of the string
        System.out.println("Length of the string: " + str.length());

        // Converting to uppercase
        System.out.println("Uppercase: " + str.toUpperCase());

        // Converting to lowercase
        System.out.println("Lowercase: " + str.toLowerCase());

        // Checking if the string contains a specific word
        System.out.println("Contains 'Java': " + str.contains("Java"));

        // Replacing a word in the string
        System.out.println("Replacing 'Java' with 'World': " + str.replace("Java", "World"));

        // Extracting a substring
        System.out.println("Substring (7-11): " + str.substring(7, 11));

        // Checking if the string starts or ends with a specific sequence
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with 'Java!': " + str.endsWith("Java!"));
    }

    // Method to demonstrate string comparison
    public void stringComparison() {
        String str1 = "Java";
        String str2 = "JAVA";
        String str3 = "Java";

        System.out.println("\nString Comparison:");
        // Equality check (case-sensitive)
        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 equals str3: " + str1.equals(str3));

        // Equality check (case-insensitive)
        System.out.println("str1 equalsIgnoreCase str2: " + str1.equalsIgnoreCase(str2));

        // Comparing lexicographically
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));
        System.out.println("str1 compareTo str3: " + str1.compareTo(str3));
    }

    // Method to demonstrate immutability of strings
    public void stringImmutability() {
        String str = "Immutable";
        System.out.println("\nString Immutability:");
        System.out.println("Original String: " + str);

        // Attempting to change the string
        String newStr = str.concat(" String");
        System.out.println("After Concatenation: " + newStr);
        System.out.println("Original String remains unchanged: " + str);
    }

    // Main method to demonstrate string manipulations
    public static void main(String[] args) {
        Strings demo = new Strings();

        // Calling the methods to demonstrate string manipulations
        demo.stringOperations();
        demo.stringComparison();
        demo.stringImmutability();
    }
}
