import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


/**.
* This program will generate a random array of integers,
* sort it using the insert sort algorithm
*
* @author Remy Skelton
* @version 1.0
* @since 2025-04-10
*/

final class InsertSort {

    /**
     * This is a constant for the array size.
     */
    public static final int ARRAY_SIZE = 10;

    /**
     * This is a constant for the maximum random number.
     */
    public static final int MAX_RANDOM_NUMBER = 100;

    /**
     * This is a constant for the minimum random number.
     */
    public static final int MIN_RANDOM_NUMBER = 1;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        System.out.println("Welcome to the Insert Sort program!");
        System.out.print("This program generates a random array,");
        System.out.print("writes it to input.txt, sorts it,");
        System.out.println("and writes the result to output.txt.");

        // Create an array of random integers
        int[] randomArray = new int[ARRAY_SIZE];

        // For loop to fill the array with random integers
        for (int index = 0; index < ARRAY_SIZE; index++) {
            // Generate a random integer between
            // MIN_RANDOM_NUMBER and MAX_RANDOM_NUMBER
            randomArray[index] =
            (int) (Math.random() * MAX_RANDOM_NUMBER + MIN_RANDOM_NUMBER);
        }

        // Write unsorted array to input.txt
        FileWriter inputWriter = new FileWriter("input.txt");

        // Print the unsorted array to input.txt
        for (int index = 0; index < ARRAY_SIZE; index++) {
            inputWriter.write(randomArray[index] + " ");
        }

        // Close the writer
        inputWriter.close();

        // Print the unsorted array to the console
        System.out.println("Unsorted array written to input.txt.");

        // Read the array back from input.txt
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        // Array to hold the integers from input.txt
        int[] inputArray = new int[ARRAY_SIZE];

        // For loop to read integers from input.txt
        for (int index = 0; index < ARRAY_SIZE; index++) {
            if (scanner.hasNextInt()) {
                inputArray[index] = scanner.nextInt();
            }
        }
        scanner.close();

        // Sort the array using insertion sort
        int[] sortedArray = insertionSort(inputArray);

        // Write unsorted array to input.txt
        FileWriter outputWriter = new FileWriter("output.txt");

        // Write unsorted array to input.txt
        outputWriter.write("Sorted array: ");

        // Print the unsorted array to input.txt
        for (int index = 0; index < ARRAY_SIZE; index++) {
            outputWriter.write(sortedArray[index] + " ");
        }
        // Close the output writer
        outputWriter.close();

        System.out.println("Sorted array written to output.txt.");
    }

    /**
     * This method sorts an array using the insertion sort algorithm.
     *
     * @param unsortedArray The array to be sorted.
     * @return The sorted array.
     */
    public static int[] insertionSort(final int[] unsortedArray) {
        // Create a new array to hold the sorted integers
        int[] sortedArray = new int[unsortedArray.length];

        // Initially, the first element of the
        // unsortedArray is copied to sortedArray
        sortedArray[0] = unsortedArray[0];

        // Iterate through the unsortedArray starting from the second element
        for (int currentIndex = 1;
                currentIndex < unsortedArray.length;
        currentIndex++) {
            // The element to be inserted into the sorted portion of the array
            int currentValue = unsortedArray[currentIndex];

            // Start by assuming the correct position
            // for currentValue is at currentIndex
            int insertIndex = currentIndex - 1;

            // Shift elements in the sorted portion
            // of the array that are greater than currentValue
            while (insertIndex >= 0
            && sortedArray[insertIndex] > currentValue) {
                sortedArray[insertIndex + 1] = sortedArray[insertIndex];
                insertIndex--;
            }

            // Insert the currentValue into the correct position
            sortedArray[insertIndex + 1] = currentValue;
        }

        // Return the sorted array
        return sortedArray;
    }

}
