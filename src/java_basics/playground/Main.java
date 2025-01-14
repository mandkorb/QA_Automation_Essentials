package java_basics.playground;

import static java_basics.playground.ArrayUtils.*;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        int[] result;

        // Int Operations
        {
            result = addElementToArray(intArray, 4);
            printArray(result);

            System.out.println();

            result = addElementToArrayBeginning(result, 0);
            printArray(result);

            System.out.println();

            result = insertElementInArray(result, 5, 4);
            printArray(result);
        }

    }
}

