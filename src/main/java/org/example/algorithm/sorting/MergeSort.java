package org.example.algorithm.sorting;

public interface MergeSort {
    void mergeSort(int[] a, int left, int right);

    void merge(int[] arr, int left, int mid, int right);
}
