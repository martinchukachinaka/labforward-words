package com.cc.labforward.notebook.words.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class WordPayload {

    @NotNull
    private String text;

    @NotNull
    private String word;
}
