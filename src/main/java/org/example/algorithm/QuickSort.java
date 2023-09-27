package org.example.algorithm;

import java.util.List;

public interface QuickSort {
    void quickSortColumns(double[][] matrix, int left, int right);

    int partition(double[][] matrix, int left, int right);

    void swapColumns(double[][] matrix, int column1, int column2);


}
