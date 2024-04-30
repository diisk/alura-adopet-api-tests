package br.com.alura.adopet.api.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AdocaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void deveriaDevolverCodigo400ParaSolicitacaoAdocaocomErros() {
        //ARRANGE
        String json = "{}";


        //ACT
        mvc.perform(
            MockServerHttpRequest.post(
                "/adocoes"            ).content
        );


        //ASSERT
        Assertions.assertEquals(400, json);
    }

}
