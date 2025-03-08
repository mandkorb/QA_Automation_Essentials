package com.basics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arrays {
    private static final Logger logger = LoggerFactory.getLogger(Arrays.class);

    // Demonstrates basic array operations
    public static void arrayOperations() {
        int[] numbers = {5, 2, 8, 1, 3};

        // Sort the array
        java.util.Arrays.sort(numbers);
        logger.info("Sorted array: {}", java.util.Arrays.toString(numbers));

        // Search for an element using binary search
        int index = java.util.Arrays.binarySearch(numbers, 8);
        logger.info("Index of 8: {}", index);

        // Fill the array with a specific value
        java.util.Arrays.fill(numbers, 0);
        logger.info("Array after filling with 0: {}", java.util.Arrays.toString(numbers));
    }

    // Demonstrates basic matrix (2D array) operations
    public static void matrixOperations() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Print the matrix
        logger.info("Matrix:");
        for (int[] row : matrix) {
            logger.info("{}", java.util.Arrays.toString(row));
        }

        // Transpose the matrix
        int[][] transposed = transposeMatrix(matrix);
        logger.info("Transposed Matrix:");
        for (int[] row : transposed) {
            logger.info("{}", java.util.Arrays.toString(row));
        }
    }

    // Helper method to transpose a matrix
    private static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void main(String[] args) {
        logger.info("Array Operations:");
        arrayOperations();

        logger.info("Matrix Operations:");
        matrixOperations();
    }
}

