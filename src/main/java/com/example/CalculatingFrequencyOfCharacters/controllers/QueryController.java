package com.example.CalculatingFrequencyOfCharacters.controllers;

import com.example.CalculatingFrequencyOfCharacters.services.CalculatingFrequencyOfCharactersService;
import com.example.CalculatingFrequencyOfCharacters.util.QueryErrorResponse;
import com.example.CalculatingFrequencyOfCharacters.util.QueryNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QueryController {
    private final CalculatingFrequencyOfCharactersService calculatingFrequencyOfCharactersService;

    @Autowired
    public QueryController(CalculatingFrequencyOfCharactersService calculatingFrequencyOfCharactersService) {
        this.calculatingFrequencyOfCharactersService = calculatingFrequencyOfCharactersService;
    }

    @GetMapping("/str")
    public String getCountCharsToString(@RequestParam String str) {
        return calculatingFrequencyOfCharactersService.getCountCharsToQuery(str);
    }


    @ExceptionHandler
    private ResponseEntity<QueryErrorResponse> handleException(QueryNotValidException e) {

        QueryErrorResponse response = new QueryErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }


}
