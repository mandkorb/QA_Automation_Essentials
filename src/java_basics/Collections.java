package java_basics;

import java.util.*;

public class Collections {
    // Method to demonstrate List operations
    public void demonstrateList() {
        System.out.println("List Operations:");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Printing the list
        System.out.println("List: " + list);

        // Accessing an element by index
        System.out.println("Element at index 1: " + list.get(1));

        // Modifying an element
        list.set(1, "Blueberry");
        System.out.println("Modified List: " + list);

        // Removing an element
        list.remove(0);
        System.out.println("After removing first element: " + list);
    }

    // Method to demonstrate Set operations
    public void demonstrateSet() {
        System.out.println("\nSet Operations:");
        Set<String> set = new HashSet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Dog"); // Duplicate element

        // Printing the set
        System.out.println("Set: " + set);

        // Checking if an element exists
        System.out.println("Contains 'Cat': " + set.contains("Cat"));
    }

    // Method to demonstrate Map operations
    public void demonstrateMap() {
        System.out.println("\nMap Operations:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Printing the map
        System.out.println("Map: " + map);

        // Accessing a value by key
        System.out.println("Value for key 2: " + map.get(2));

        // Iterating over keys and values
        System.out.println("Iterating over map:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    // Main method to demonstrate collections
    public static void main(String[] args) {
        Collections demo = new Collections();

        // Demonstrating List
        demo.demonstrateList();

        // Demonstrating Set
        demo.demonstrateSet();

        // Demonstrating Map
        demo.demonstrateMap();
    }
}
