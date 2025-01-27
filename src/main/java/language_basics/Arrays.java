package language_basics;

public class Arrays {

    // Demonstrates basic array operations
    public static void arrayOperations() {
        int[] numbers = {5, 2, 8, 1, 3};

        // Sort the array
        java.util.Arrays.sort(numbers);
        System.out.println("Sorted array: " + java.util.Arrays.toString(numbers));

        // Search for an element using binary search
        int index = java.util.Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);

        // Fill the array with a specific value
        java.util.Arrays.fill(numbers, 0);
        System.out.println("Array after filling with 0: " + java.util.Arrays.toString(numbers));
    }

    // Demonstrates basic matrix (2D array) operations
    public static void matrixOperations() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Print the matrix
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }

        // Transpose the matrix
        int[][] transposed = transposeMatrix(matrix);
        System.out.println("Transposed Matrix:");
        for (int[] row : transposed) {
            System.out.println(java.util.Arrays.toString(row));
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
        System.out.println("Array Operations:");
        arrayOperations();

        System.out.println("\nMatrix Operations:");
        matrixOperations();
    }
}

