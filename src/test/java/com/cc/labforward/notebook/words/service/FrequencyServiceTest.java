package com.cc.labforward.notebook.words.service;

import com.cc.labforward.notebook.words.requests.WordPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class FrequencyServiceTest {

    FrequencyService frequencyService;


    @BeforeEach
    void setup() {
        frequencyService = new FrequencyService();
    }


    @Test
    @DisplayName("Given a text, it should find the frequency of the given word")
    void itShouldFindWordFrequencyGivenAWord() {
        WordPayload payload = new WordPayload();
        payload.setWord("Word");
        payload.setText("Word Words Wor word");

        WordPayload payload2 = new WordPayload();
        payload2.setWord("Word");
        payload2.setText("Word Word Word word");

        Integer result = frequencyService.findFrequency(payload);
        Integer result2 = frequencyService.findFrequency(payload2);

        assertThat(result).isEqualTo(1);
        assertThat(result2).isEqualTo(3);
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
