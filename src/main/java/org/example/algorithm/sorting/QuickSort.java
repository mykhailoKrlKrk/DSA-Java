package org.example.algorithm.sorting;

import java.util.List;

public interface QuickSort {
    void quickSort(int[] inputArray, int left, int right);

    int partition(int[] arr, int low, int high);

    void swap(int[] arr, int i, int j);

    List<int[]> getIterations();
}
