package org.example.algorithm.search.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.algorithm.search.BinarySearch;

public class BinarySearchImpl implements BinarySearch {
    public List<String[]> iterations = new ArrayList<>();

    public List<String[]> getIterations() {
        return iterations;
    }

    @Override
    public int binarySearchBookPrice(String[] books, List<Integer> prices, String bookToFind) {
        if (books.length != prices.size()) {
            throw new IllegalArgumentException("The arrays 'books' and 'prices' must have the same length.");
        }
        Arrays.sort(books);

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String currentBookName = books[mid];
            int comparisonResult = currentBookName.compareTo(bookToFind);

            if (comparisonResult == 0) {
                int bookIndex = Arrays.asList(books).indexOf(currentBookName);
                return prices.get(bookIndex);
            } else if (comparisonResult < 0) {
                iterations.add(Arrays.copyOfRange(books, mid , books.length - 1));
                low = mid + 1;
            } else {
                iterations.add(Arrays.copyOfRange(books, 0 , mid));
                high = mid - 1;
            }
        }
        return -1;
    }
}
