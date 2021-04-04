package com.cc.labforward.notebook.words;

import com.cc.labforward.notebook.words.requests.WordPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestUtility {

    private static TestUtility instance;

    private TestUtility(){
        if(instance !=null){
            throw new IllegalStateException("use the getInstance method please");
        }
    }

    public static TestUtility getInstance(){
        if(instance == null){
            synchronized (TestUtility.class){
                if(instance == null ){
                    instance = new TestUtility();
                }
            }
        }
        return instance;
    }


    public String asJsonString(WordPayload payload) {
        try {
            return new ObjectMapper().writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
