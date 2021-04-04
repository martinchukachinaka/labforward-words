package com.cc.labforward.notebook.words.service;

import com.cc.labforward.notebook.words.requests.WordPayload;
import com.cc.labforward.notebook.words.util.PayloadValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;


class FrequencyServiceTest {

    FrequencyService frequencyService;


    @BeforeEach
    void setup() {
        frequencyService = new FrequencyService(mock(PayloadValidator.class));
    }


    @Test
    @DisplayName("Given a text, it should find the frequency of the given word")
    void itShouldFindWordFrequencyGivenAWord() {
        WordPayload payload = new WordPayload();
        payload.setWord("Word");
        payload.setText("Word Words Wor word");

        Integer result = frequencyService.findFrequency(payload);

        assertNotNull(result);
        assertThat(result).isEqualTo(1);
    }


    @Test
    @DisplayName("Given an empty text, it should immediately return 0")
    void itShouldHandleEdgeCaseOfNoText() {
        WordPayload payload = new WordPayload();
        payload.setWord("Word");
        payload.setText("");

        Integer result = frequencyService.findFrequency(payload);

        assertThat(result).isEqualTo(0);
    }
}
