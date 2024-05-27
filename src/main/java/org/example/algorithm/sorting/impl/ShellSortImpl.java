package org.example.algorithm.sorting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.sorting.ShallSort;

public class ShellSortImpl implements ShallSort {
    @Override
    public List<int[]> shallSort(int[] inputArray) {
        //Store the sorting iterations
        List<int[]> iterations = new ArrayList<>();

        int arrayLength = inputArray.length;
        // Start with a big gap, then reduce the gap
        for (int gap = arrayLength / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrayLength; i++) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = inputArray[i];
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j = i;
                while (j >= gap && inputArray[j - gap] > temp) {
                    inputArray[j] = inputArray[j - gap];
                    j -= gap;
                }
                // put temp (the original a[i]) in its correct
                // location
                inputArray[j] = temp;
                iterations.add(Arrays.copyOf(inputArray, inputArray.length));
            }
        }
        return iterations;
    }
}
