package com.cc.labforward.notebook.words.service;

import com.cc.labforward.notebook.words.requests.WordPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FrequencyService {

    public Integer findFrequency(WordPayload request) {
        String[] words = request.getText().split("\\W+");
        if (words.length == 0) {
            return 0;
        }
        Integer frequency = 0;
        for (String aWord : words) {
            if (aWord.equals(request.getWord())) {
                ++frequency;
            }
        }
        return frequency;
    }
}
