package org.example.algorithm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.MergeSort;

public class MergeSortImpl implements MergeSort {
    private final List<int[]> intermediateIterations = new ArrayList<>();

    @Override
    public void mergeSort(int[] a, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    @Override
    public void merge(int[] inputArray, int left, int mid, int right) {
        int i, j, k;
        int rightSize = mid - left + 1;
        int leftSize = right - mid;

        int[] leftHalf = new int[rightSize];
        int[] rightHalf = new int[leftSize];

        for (i = 0; i < rightSize; i++)
            leftHalf[i] = inputArray[left + i];
        for (j = 0; j < leftSize; j++)
            rightHalf[j] = inputArray[mid + 1 + j];

        i = 0;
        j = 0;
        k = left;

        while (i < rightSize && j < leftSize) {
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
        while (i < rightSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
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

    public int[] processAndSortArray(int[] inputArray) {
        int[] counts = new int[inputArray.length];
        Arrays.fill(counts, 0);

        for (int i = 0; i < inputArray.length; i++) {
            for (int k : inputArray) {
                if (inputArray[i] == k) {
                    counts[i]++;
                }
            }
        }

        int mode = inputArray[0];
        int modeCount = counts[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (counts[i] > modeCount) {
                mode = inputArray[i];
                modeCount = counts[i];
            }
        }

        List<Integer> modifiedList = new ArrayList<>();
        for (int value : inputArray) {
            if (value != mode) {
                modifiedList.add(value);
            }
        }

        int[] modifiedArray = new int[modifiedList.size()];
        for (int i = 0; i < modifiedList.size(); i++) {
            modifiedArray[i] = modifiedList.get(i);
        }

        mergeSort(modifiedArray, 0, modifiedArray.length - 1);
        return modifiedArray;
    }
}
