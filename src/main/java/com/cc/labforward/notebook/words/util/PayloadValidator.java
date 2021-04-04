package com.cc.labforward.notebook.words.util;

import com.cc.labforward.notebook.words.config.AppConfig;
import com.cc.labforward.notebook.words.requests.WordPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class PayloadValidator {

    private final AppConfig config;

    public void validateRequest(WordPayload request) {
        Objects.requireNonNull(request, config.getInvalidPayload());
        Objects.requireNonNull(request.getText(), "Please provide a text to work with");
        if (!StringUtils.hasText(request.getWord())) {
            throw new IllegalArgumentException("Please provide a word to work with");
        }
    }
}
