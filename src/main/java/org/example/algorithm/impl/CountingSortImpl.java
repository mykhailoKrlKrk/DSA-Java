package org.example.algorithm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.CountingSort;

public class CountingSortImpl implements CountingSort {
    public List<int[]> getIterations() {
        return iterations;
    }

    private final List<int[]> iterations = new ArrayList<>();

    @Override
    public int[] sort(int[] inputArray) {

        //Find the largest element in array
        int max = Arrays.stream(inputArray).max().orElse(Integer.MAX_VALUE);

        //Create the counting array for store number of element occurrences
        int[] count = new int[max + 1];

        //Create array for sorting result
        int[] result = new int[inputArray.length];

        //Find the number of each element
        for (int j : inputArray) {
            count[j]++;
        }

        //Calculate the sum
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Set the elements in the corresponding place in the result array
        for (int i = inputArray.length - 1; i >= 0; i--) {
            result[count[inputArray[i]] - 1] = inputArray[i];
            count[inputArray[i]]--;
            iterations.add(Arrays.copyOf(result, result.length));
        }
        return result;
    }
}
