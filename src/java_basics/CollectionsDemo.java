package java_basics;

import java.util.*;

public class CollectionsDemo {
    // Method to demonstrate List operations
    public void demonstrateList() {
        System.out.println("List Operations:");
        List<String> list = new ArrayList<>();
        list.add("Cherry");
        list.add("Banana");
        list.add("Apple");

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

        // Iterating over array
        System.out.print("Loop through an array: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

/*
        Other 2 methods of iterating described below

        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();

        Use Iterator for removing and looping Set & Queue Collections
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
*/

        // Sorting an array
        System.out.print("After sorting: ");
        Collections.sort(list);
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
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

        // Print all keys and values
        // Suitable if you want to loop through keys or values
        Set<Integer> integers = map.keySet();
        Collection<String> values = map.values();

        System.out.println("Keys collection: " + integers);
        System.out.println("Values collection: " + values);
    }

    // Main method to demonstrate collections
    public static void main(String[] args) {
        CollectionsDemo demo = new CollectionsDemo();

        // Demonstrating List
        demo.demonstrateList();

        // Demonstrating Set
        demo.demonstrateSet();

        // Demonstrating Map
        demo.demonstrateMap();
    }
}
