package org.example.algorithm.search.impl;

import org.example.algorithm.search.KMPAlgorithm;

public class KMPAlgorithmImpl implements KMPAlgorithm {

    @Override
    public Result findShortestWordAndIndex(String text1, String text2) {
        String shortestWord = findShortestWord(text1);
        int[] lpsArray = computeLPSArray(shortestWord);
        int i = 0;
        int j = 0;

        while (i < text2.length()) {
            if (shortestWord.charAt(j) == text2.charAt(i)) {
                i++;
                j++;
            }

            if (j == shortestWord.length()) {
                return new Result(shortestWord, i - j);
            } else if (i < text2.length() && shortestWord.charAt(j) != text2.charAt(i)) {
                if (j != 0) {
                    j = lpsArray[j - 1];
                } else {
                    i++;
                }
            }
        }

        return new Result("", -1);
    }

    @Override
    public String findShortestWord(String text) {
        String[] words = text.split("\\s+");
        String shortestWord = words[0];

        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }

        return shortestWord;
    }

    @Override
    public int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
