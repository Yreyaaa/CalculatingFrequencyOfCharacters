package com.example.CalculatingFrequencyOfCharacters;

import com.example.CalculatingFrequencyOfCharacters.util.QueryNotValidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryNotValidExceptionTest {

    QueryNotValidException queryNotValidException;


    @Test
    void getMessage() {
        queryNotValidException = new QueryNotValidException("Message");

        assertEquals("Message", queryNotValidException.getMessage());
    }

    @Test
    void setMessage() {
        queryNotValidException = new QueryNotValidException("Message");
        queryNotValidException.setMessage("Message2");
        assertEquals("Message2", queryNotValidException.getMessage());

    }
}