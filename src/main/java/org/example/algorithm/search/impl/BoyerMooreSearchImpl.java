package org.example.algorithm.search.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.algorithm.search.BoyerMooreSearch;

public class BoyerMooreSearchImpl implements BoyerMooreSearch {

    @Override
    public List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] last = buildLast(pattern);

        int i = pattern.length() - 1;
        int j = pattern.length() - 1;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == 0) {
                    result.add(i);
                    i += pattern.length();
                    j = pattern.length() - 1;
                } else {
                    i--;
                    j--;
                }
            } else {
                i += pattern.length() - Math.min(j, 1 + last[text.charAt(i)]);
                j = pattern.length() - 1;
            }
        }

        Collections.reverse(result);
        return result;
    }

    private int[] buildLast(String pattern) {
        int[] last = new int[256];

        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        }

        return last;
    }
}

