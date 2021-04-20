package com.cc.labforward.notebook.words.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class WordPayload {

    @NotBlank(message = "Please provide a word to work with")
    private String text;

    @NotBlank(message = "Please provide a text to work with")
    private String word;
}
