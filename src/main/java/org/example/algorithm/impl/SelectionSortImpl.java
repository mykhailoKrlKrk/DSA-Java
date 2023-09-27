package org.example.algorithm.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.algorithm.SelectionSort;

public class SelectionSortImpl implements SelectionSort {

    @Override
    public void selectionSort(List<String> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    @Override
    public List<String> sortAndFilterProducts(List<String> products) {
        double total = 0;
        for (String product : products) {
            String[] parts = product.split(":");
            double price = Double.parseDouble(parts[1].trim());
            total += price;
        }
        double averagePrice = total / products.size();

        List<String> filteredProducts = new ArrayList<>();
        for (String product : products) {
            String[] parts = product.split(":");
            String name = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            if (price <= averagePrice) {
                filteredProducts.add(name + ": " + price);
            }
        }

        selectionSort(filteredProducts);
        return filteredProducts;
    }
}
