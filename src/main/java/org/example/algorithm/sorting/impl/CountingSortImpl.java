package org.example.algorithm.sorting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.sorting.CountingSort;

public class CountingSortImpl implements CountingSort {
    public List<int[]> getIterations() {
        return iterations;
    }

    private final List<int[]> iterations = new ArrayList<>();

    @Override
    public int[] sort(int[] inputArray) {
        // Find the largest and smallest elements in array
        int max = Arrays.stream(inputArray).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(inputArray).min().orElse(0);

        // Create the counting array for storing the number of element occurrences
        int[] count = new int[max - min + 1];

        // Create array for sorting result
        int[] result = new int[inputArray.length];

        // Find the number of each element
        for (int j : inputArray) {
            count[j - min]++;
        }

        // Calculate the sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Set the elements in the corresponding place in the result array
        for (int i = inputArray.length - 1; i >= 0; i--) {
            int current = inputArray[i];
            int positionInArray = count[current - min] - 1;
            result[positionInArray] = current;
            count[current - min]--;
            iterations.add(Arrays.copyOf(result, result.length));
        }

        // Copy the result back to the input array
        System.arraycopy(result, 0, inputArray, 0, inputArray.length);

        return result;
    }
}
