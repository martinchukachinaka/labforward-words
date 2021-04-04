package com.cc.labforward.notebook.words.rest.similar;

import com.cc.labforward.notebook.words.TestUtility;
import com.cc.labforward.notebook.words.requests.WordPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
class WordSimilarityControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("POST /words/similar - Success")
    void testForSimilarities() throws Exception {
        WordPayload payload = new WordPayload();
        payload.setWord("Word");
        payload.setText("Word Words Wor word");

        mockMvc.perform(post("/words/similar").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtility.getInstance().asJsonString(payload)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
