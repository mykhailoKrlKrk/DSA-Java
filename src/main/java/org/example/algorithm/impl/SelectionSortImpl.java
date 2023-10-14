package org.example.algorithm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.SelectionSort;

public class SelectionSortImpl implements SelectionSort {

    @Override
    public List<int[]> selectionSort(int[] inputArray) {
        //Store iterations of sorting
        List<int[]> iterations = new ArrayList<>();
        int arrayLength = inputArray.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arrayLength - 1; i++) {
            // Adding a copy of the array
            iterations.add(Arrays.copyOf(inputArray, inputArray.length));
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++)
                if (inputArray[j] < inputArray[minIndex])
                    minIndex = j;

            // Swap the found minimum element with the element at index [i]
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;
        }
        // Adding a copy of the array after the last iteration
        iterations.add(Arrays.copyOf(inputArray, inputArray.length));
        return iterations;
    }
}
