package com.cc.labforward.notebook.words.service;

import com.cc.labforward.notebook.words.config.AppConfig;
import com.cc.labforward.notebook.words.requests.WordPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class SimilarityService {

    private final LevenshteinService levenshteinService;

    private final AppConfig config;


    public List<String> findSimilarWords(WordPayload request) {
        List<String> similarWords = new ArrayList<>();

        List<String> words = extractWordToSearch(request);
        for (String aWord : words) {
            if (wordsAreSimilar(aWord, request.getWord())) {
                similarWords.add(aWord);
            }
        }
        return similarWords;
    }


    private List<String> extractWordToSearch(WordPayload request) {
        return Arrays.stream(request.getText().split("\\W+"))
                .filter(word -> !word.equals(request.getWord()))
                .collect(toList());
    }


    private boolean wordsAreSimilar(String currentWord, String searchWord) {
        return levenshteinService.getWordDistance(currentWord, searchWord) <= config.getMaxLengthForSimilarity();
    }

}
