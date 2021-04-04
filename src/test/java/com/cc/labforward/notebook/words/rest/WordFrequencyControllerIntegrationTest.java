package com.cc.labforward.notebook.words.rest;

import com.cc.labforward.notebook.words.requests.WordPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
class WordFrequencyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("POST /frequency - Success")
    void testGetProductByIdFound() throws Exception {
        WordPayload payload = new WordPayload();
        payload.setWord("Word");
        payload.setText("Word Words Wor word");

        mockMvc.perform(post("/frequency").contentType(MediaType.APPLICATION_JSON).content(asJsonString(payload)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", is(1)));
    }


    private String asJsonString(WordPayload payload) {
        try {
            return new ObjectMapper().writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
