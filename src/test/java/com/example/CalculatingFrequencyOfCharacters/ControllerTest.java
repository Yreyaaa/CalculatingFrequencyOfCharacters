package com.example.CalculatingFrequencyOfCharacters;

import com.example.CalculatingFrequencyOfCharacters.services.CalculatingFrequencyOfCharactersService;
import com.example.CalculatingFrequencyOfCharacters.util.QueryNotValidException;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ControllerTest {
    private static final String query = "str";
    @Autowired
    CalculatingFrequencyOfCharactersService calculatingFrequencyOfCharactersService;
    @Autowired
    private MockMvc mockMvc;

    @org.junit.Test
    @AutoConfigureMockMvc
    public void getCountCharsToQueryTest() {

        String testRequest = "lsdg LHUppp96  asd";
        String testResponse = "' ':3, 'p':3, 's':2, 'd':2, 'a':1, 'U':1, '6':1, 'g':1, 'H':1, '9':1, 'l':1, 'L':1";

        Assertions.assertEquals(testResponse, calculatingFrequencyOfCharactersService.getCountCharsToQuery(testRequest));
    }

    @org.junit.Test(expected = QueryNotValidException.class)
    @AutoConfigureMockMvc
    public void getCountCharsToQueryWithEmptyQueryTest() {

        calculatingFrequencyOfCharactersService.getCountCharsToQuery("");
    }

    @org.junit.Test
    public void controllerTestOk() throws Exception {
        var request = MockMvcRequestBuilders.get("/str").queryParam(query, "lsdg LHUppp96  asd");

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @org.junit.Test
    public void controllerTestException() throws Exception {
        var request = MockMvcRequestBuilders.get("/str").queryParam(query, "");

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
