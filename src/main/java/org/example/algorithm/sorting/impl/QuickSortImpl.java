package org.example.algorithm.sorting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.sorting.QuickSort;

public class QuickSortImpl implements QuickSort {
    private final List<int[]> iterations = new ArrayList<>();

    public List<int[]> getIterations() {
        return iterations;
    }

    @Override
    public void quickSort(int[] inputArray, int left, int right) {

        if (left < right) {
            int indexPI = partition(inputArray, left, right);

            quickSort(inputArray, left, indexPI - 1);  //left partition
            quickSort(inputArray, indexPI + 1, right); //right partition
        }
    }

    @Override
    public int partition(int[] inputArray, int low, int high) {
        // Pivot element selected as right most element in array each time.
        int pivot = inputArray[high];
        int swapIndex = (low - 1);   //swapping index.

        for (int j = low; j <= high - 1; j++) {
            //Check if current element is smaller than pivot element.
            if (inputArray[j] < pivot) {
                swapIndex++;    //increment swapping index.
                swap(inputArray, swapIndex, j);
            }
        }
        // swap swapIndex + 1 and pivot index
        // we assigned pivot = inputArray[high] is pivot index is high

        swap(inputArray, swapIndex + 1, high);
        iterations.add(Arrays.copyOf(inputArray, inputArray.length));
        return (swapIndex + 1);
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
