package com.example.CalculatingFrequencyOfCharacters.util;

public class QueryErrorResponse {
    private String message;

    public QueryErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
