package com.example.CalculatingFrequencyOfCharacters;

import com.example.CalculatingFrequencyOfCharacters.util.QueryErrorResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryErrorResponseTest {
    QueryErrorResponse queryErrorResponse;


    @Test
    void getMessage() {
        queryErrorResponse = new QueryErrorResponse("Message");

        assertEquals("Message", queryErrorResponse.getMessage());
    }

    @Test
    void setMessage() {
        queryErrorResponse = new QueryErrorResponse("Message");
        queryErrorResponse.setMessage("Message2");
        assertEquals("Message2", queryErrorResponse.getMessage());

    }
}