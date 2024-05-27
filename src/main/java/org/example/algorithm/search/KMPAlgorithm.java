package org.example.algorithm.search;

public interface KMPAlgorithm {
    Result findShortestWordAndIndex(String text1, String text2);

    String findShortestWord(String text);

    int[] computeLPSArray(String pattern);

    class Result {
        String shortestWord;
        int index;

        public Result(String shortestWord, int index) {
            this.shortestWord = shortestWord;
            this.index = index;
        }

        public String getShortestWord() {
            return shortestWord;
        }

        public int getIndex() {
            return index;
        }
    }
}
