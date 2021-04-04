package com.cc.labforward.notebook.words.rest.similar;

import com.cc.labforward.notebook.words.requests.WordPayload;
import com.cc.labforward.notebook.words.service.SimilarityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("words")
@RequiredArgsConstructor
public class WordSimilarityController {

    private final SimilarityService similarityService;


    @PostMapping("similar")
    public ResponseEntity<List<String>> determineFrequency(@RequestBody @Valid WordPayload request) {
        return ResponseEntity.ok(similarityService.findSimilarWords(request));
    }
}
