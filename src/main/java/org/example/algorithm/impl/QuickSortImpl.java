package org.example.algorithm.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.algorithm.QuickSort;

public class QuickSortImpl implements QuickSort {
    private final List<double[][]> iterations = new ArrayList<>();

    @Override
    public void quickSortColumns(double[][] matrix, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(matrix, left, right);
            quickSortColumns(matrix, left, pivotIndex - 1);
            quickSortColumns(matrix, pivotIndex + 1, right);
        }
    }

    @Override
    public int partition(double[][] matrix, int left, int right) {
        double pivot = matrix[0][right];
        int swap = left - 1;

        for (int j = left; j < right; j++) {
            if (matrix[0][j] < pivot) {
                swap++;
                swapColumns(matrix, swap, j);
            }
            double[][] copy = deepCopy(matrix);
            iterations.add(copy);
        }

        swapColumns(matrix, swap + 1, right);
        double[][] copy = deepCopy(matrix);
        iterations.add(copy);
        return swap + 1;
    }

    @Override
    public void swapColumns(double[][] matrix, int column1, int column2) {
        for (int i = 0; i < matrix.length; i++) {
            double temp = matrix[i][column1];
            matrix[i][column1] = matrix[i][column2];
            matrix[i][column2] = temp;
        }
    }

    private double[][] deepCopy(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] copy = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, cols);
        }

        return copy;
    }

    public List<double[][]> getIterations() {
        return iterations;
    }
}
