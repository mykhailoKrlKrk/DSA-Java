package org.example.algorithm.sorting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.sorting.MergeSort;

public class MergeSortImpl implements MergeSort {
    private final List<int[]> intermediateIterations = new ArrayList<>();

    @Override
    public void mergeSort(int[] a, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;

            // recursive calls to sort first half and second half sub-arrays
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    // after sorting this function merge the array
    @Override
    public void merge(int[] inputArray, int left, int mid, int right) {
        int i, j, k;
        int rightSize = mid - left + 1;
        int leftSize = right - mid;

        // create temp arrays to store left and right sub-arrays
        int[] leftHalf = new int[rightSize];
        int[] rightHalf = new int[leftSize];

        // Copying data to temp arrays L[] and R[]
        for (i = 0; i < rightSize; i++)
            leftHalf[i] = inputArray[left + i];
        for (j = 0; j < leftSize; j++)
            rightHalf[j] = inputArray[mid + 1 + j];

        // here we merge the temp arrays back into arr[l.r]
        i = 0; // Starting index of L[i]
        j = 0; // Starting index of R[i]
        k = left; // Starting index of merged sub-array

        while (i < rightSize && j < leftSize) {

            // place the smaller item at arr[k] pos
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
            int[] arrCopy = Arrays.copyOf(inputArray, inputArray.length);
            intermediateIterations.add(arrCopy);
        }
        // Copy the remaining elements of L[], if any
        while (i < rightSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        // Copy the remaining elements of R[], if any
        while (j < leftSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
        int[] arrCopy = Arrays.copyOf(inputArray, inputArray.length);
        intermediateIterations.add(arrCopy);
    }

    public List<int[]> getIntermediateIterations() {
        return intermediateIterations;
    }
}
