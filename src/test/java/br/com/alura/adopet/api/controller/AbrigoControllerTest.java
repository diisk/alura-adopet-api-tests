package br.com.alura.adopet.api.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.service.AbrigoService;
import br.com.alura.adopet.api.service.PetService;

@SpringBootTest
@AutoConfigureMockMvc
public class AbrigoControllerTest {

    @MockBean
    private AbrigoService abrigoService;

    @MockBean
    private PetService petService;

    @Mock
    private Abrigo abrigo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaDevolverCodigo200ParaRequisicaoDeListarAbrigos() throws Exception {
        // ACT
        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/abrigos")).andReturn().getResponse();

        // ASSERT
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void deveriaDevolverCodigo200ParaRequisicaoDeCadastrarAbrigo() throws Exception {
        // ARRANGE
        String json = """
                {
                    "nome": "Abrigo feliz",
                    "telefone": "(94)0000-9090",
                    "email": "email@example.com.br"
                }
                """;

        //ACT
        MockHttpServletResponse response = mockMvc.perform(
            MockMvcRequestBuilders.post("/abrigos")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)

        ).andReturn().getResponse();

        //ASSERT
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    void deveriaDevolverCodigo400ParaRequisicaoDeCadastrarAbrigo() throws Exception {
        // ARRANGE
        String json = """
                {
                    
                }
                """;

        //ACT
        MockHttpServletResponse response = mockMvc.perform(
            MockMvcRequestBuilders.post("/abrigos")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)

        ).andReturn().getResponse();

        //ASSERT
        Assertions.assertEquals(400, response.getStatus());
    }
}
