package com.cc.labforward.notebook.words.rest.frequency;

import com.cc.labforward.notebook.words.requests.WordPayload;
import com.cc.labforward.notebook.words.service.FrequencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("words")
@RequiredArgsConstructor
public class WordFrequencyController {

    private final FrequencyService frequencyService;


    @PostMapping("frequency")
    public ResponseEntity<?> determineFrequency(@RequestBody @Valid WordPayload request) {
        return ResponseEntity.ok(frequencyService.findFrequency(request));
    }
}
