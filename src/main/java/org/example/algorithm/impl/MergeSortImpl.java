package org.example.algorithm.impl;

import org.example.algorithm.MergeSort;

public class MergeSortImpl implements MergeSort {
    @Override
    public void mergeSort(int[] a, int left, int right)
    {
        int mid;
        if(left < right)
        {
            mid = (left + right) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }
    @Override
    public void merge(int[] arr, int left, int mid, int right)
    {
        int i, j, k;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copying data to temp arrays L[] and R[]
        for (i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // here we merge the temp arrays back into arr[l..r]
        i = 0; // Starting index of L[i]
        j = 0;
        k = left;

        while (i < n1 && j < n2)
        {
            // place the smaller item at arr[k] pos
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
