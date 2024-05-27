package org.example.algorithm.search;

import java.util.List;

public interface BinarySearch {
     int binarySearchBookPrice(String[] books, List<Integer> prices, String bookToFind);
     List<String[]> getIterations();
}
