package com.cc.labforward.notebook.words.service;

import com.cc.labforward.notebook.words.config.AppConfig;
import com.cc.labforward.notebook.words.requests.WordPayload;
import com.cc.labforward.notebook.words.util.PayloadValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


class SimilarityServiceTest {

    SimilarityService similarityService;


    @BeforeEach
    void setUp() {
        PayloadValidator payloadValidator = mock(PayloadValidator.class);
        LevenshteinService levenshteinService = new LevenshteinService();
        AppConfig config = new AppConfig();
        config.setMaxLengthForSimilarity(1);

        similarityService = new SimilarityService(payloadValidator, levenshteinService, config);
    }


    @DisplayName("Given a text and words, it should return words from text similar to provided word")
    @Test
    void itShouldReturnSimilarWords() {
        WordPayload payload = new WordPayload();
        payload.setText("Word Words Wor word");
        payload.setWord("Word");

        List<String> similarWords = similarityService.findSimilarWords(payload);

        assertThat(similarWords).hasSize(3);
    }
}
