package com.cc.labforward.notebook.words.util;

import com.cc.labforward.notebook.words.config.AppConfig;
import com.cc.labforward.notebook.words.requests.WordPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class PayloadValidatorTest {

    PayloadValidator payloadValidator;
    AppConfig config;

    @BeforeEach
    void setUp() {
        config = new AppConfig();
        config.setMaxLengthForSimilarity(1);
        config.setInvalidPayload("A payload is expected. Please provide a valid one");
        payloadValidator = new PayloadValidator(config);
    }




    @Test
    @DisplayName("Given a null request, it should reject request and provide explanation")
    void itShouldRejectNullPayloadWithReason() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            payloadValidator.validateRequest(null);
        });
        assertThat(exception.getMessage()).isEqualTo(config.getInvalidPayload());
    }


    @Test
    @DisplayName("Given an empty word, it should complain of the request")
    void itShouldComplainOfEmptyWords() {
        WordPayload payload = new WordPayload();
        payload.setWord(null);
        payload.setText("Word Words Wor word");

        assertThrows(IllegalArgumentException.class, () -> {
            payloadValidator.validateRequest(payload);
        });
    }

    @Test
    @DisplayName("Given a null text, it should complain of the request not having a text")
    void itShouldComplainOfEmptyTexts() {
        WordPayload payload = new WordPayload();
        payload.setWord("Words words words");
        payload.setText(null);

        assertThrows(NullPointerException.class, () -> {
            payloadValidator.validateRequest(payload);
        });
    }

}
