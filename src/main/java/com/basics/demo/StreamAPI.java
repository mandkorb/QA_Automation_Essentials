package com.basics.demo;

import java.util.Arrays;
import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> names = List.of("John", "Alice", "Bob", "John", "Charlie");
        System.out.println("Original list: " + names);

        System.out.println("Filtered (starts with 'J'): " +
                names.stream().filter(name -> name.startsWith("J")).toList());

        System.out.println("Mapped to uppercase: " +
                names.stream().map(String::toUpperCase).toList());

        System.out.println("Sorted: " +
                names.stream().sorted().toList());

        System.out.println("Distinct: " +
                names.stream().distinct().toList());

        System.out.println("First element starting with 'A': " +
                names.stream().filter(name -> name.startsWith("A")).findFirst().orElse("None"));

        System.out.println("Count of names with length > 4: " +
                names.stream().filter(name -> name.length() > 4).count());

        System.out.println("Reduced (concatenated with comma): " +
                names.stream().reduce("", (a, b) -> a + (a.isEmpty() ? "" : ", ") + b));

        System.out.println("Parallel Stream (unordered): " +
                names.parallelStream().toList());

        System.out.println("Any match for 'Bob': " +
                names.stream().anyMatch(name -> name.equals("Bob")));
    }
}
