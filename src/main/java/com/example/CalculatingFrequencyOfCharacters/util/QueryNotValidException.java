package com.example.CalculatingFrequencyOfCharacters.util;

public class QueryNotValidException extends RuntimeException {
    private String message;

    public QueryNotValidException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
