package com.cc.labforward.notebook.words.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class LevenshteinService {

    public int getWordDistance(String currentWord, String searchWord) {
        int[][] distanceBetweenPrefixes = new int[currentWord.length()][searchWord.length()];
        for (int[] row : distanceBetweenPrefixes) {
            Arrays.fill(row, -1);
        }
        return buildDistances(currentWord, currentWord.length() - 1, searchWord, searchWord.length() - 1,
                distanceBetweenPrefixes);
    }


    private int buildDistances(String currentWord, int currentWordIndex, String searchWord, int searchWordIndex,
            int[][] distances) {
        if (currentWordIndex < 0) {
            return searchWordIndex + 1;
        } else if (searchWordIndex < 0) {
            return currentWordIndex + 1;
        }

        if (distances[currentWordIndex][searchWordIndex] == -1) {
            if (currentWord.charAt(currentWordIndex) == searchWord.charAt(searchWordIndex)) {
                distances[currentWordIndex][searchWordIndex] = buildDistances(currentWord, currentWordIndex - 1,
                        searchWord, searchWordIndex - 1, distances);
            } else {
                int substituteLast = buildDistances(currentWord, currentWordIndex - 1, searchWord, searchWordIndex - 1,
                        distances);
                int addLast = buildDistances(currentWord, currentWordIndex, searchWord, searchWordIndex - 1, distances);
                int deleteLast = buildDistances(currentWord, currentWordIndex - 1, searchWord, searchWordIndex,
                        distances);
                distances[currentWordIndex][searchWordIndex] = 1 + Math.min(substituteLast,
                        Math.min(addLast, deleteLast));
            }
        }
        return distances[currentWordIndex][searchWordIndex];
    }


}
