package org.example.algorithm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.ShallSort;

public class ShellSortImpl implements ShallSort {
    @Override
    public List<int[]> shallSort(int[] numbers) {
        List<int[]> iterations = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                int value = numbers[i];
                numbers[i] = (int) (Math.sqrt(Math.abs(value - 10)));
            }
        }
        iterations.add(Arrays.copyOf(numbers, numbers.length));

        int n = numbers.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = numbers[i];
                int j = i;
                while (j >= gap && numbers[j - gap] > key) {
                    numbers[j] = numbers[j - gap];
                    j -= gap;
                }
                numbers[j] = key;
                iterations.add(Arrays.copyOf(numbers, numbers.length));
            }
        }
        return iterations;
    }
}
