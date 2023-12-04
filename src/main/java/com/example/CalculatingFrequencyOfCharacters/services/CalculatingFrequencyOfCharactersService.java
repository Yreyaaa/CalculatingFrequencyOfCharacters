package com.example.CalculatingFrequencyOfCharacters.services;


import com.example.CalculatingFrequencyOfCharacters.util.QueryNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class CalculatingFrequencyOfCharactersService {
    public String getCountCharsToQuery(String query) {
        if (query.isEmpty()) {
            throw new QueryNotValidException("Введен пустой запрос, запрос должен содержать 1 или более символов");
        }
        Map<Character, Integer> mspSymbolsAndFrequencyOccurrence = new HashMap<>();
        char[] arrayOfQueryCharacters = query.toCharArray();
        int numberOccurrencesSymbol;
        for (char queryCharacter : arrayOfQueryCharacters) {
            numberOccurrencesSymbol = mspSymbolsAndFrequencyOccurrence.getOrDefault(queryCharacter, 0);
            numberOccurrencesSymbol++;
            mspSymbolsAndFrequencyOccurrence.put(queryCharacter, numberOccurrencesSymbol);
        }
        List<Map.Entry<Character, Integer>> resultList = mspSymbolsAndFrequencyOccurrence.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).toList();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            Map.Entry<Character, Integer> item = resultList.get(i);
            result.append(String.format("\"%s\":%d, ", item.getKey(), item.getValue()));
            if (i == resultList.size() - 1) {
                result.delete(result.length() - 2, result.length());
            }
        }
        return result.toString();
    }
}


