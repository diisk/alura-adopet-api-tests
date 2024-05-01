package br.com.alura.adopet.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.alura.adopet.api.service.TutorService;

@SpringBootTest
@AutoConfigureMockMvc
class TutorControllerTest {

    @MockBean
    private TutorService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaDevolverCodigo200ParaRequisicaoDeCadastrarTutor() throws Exception {
        // Arrange
        String json = """
                {
                    "nome": "Rodrigo",
                    "telefone": "(21)0000-9090",
                    "email": "email@example.com.br"
                }
                """;
        // Act
        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.post("/tutores")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Assert
        assertEquals(200, response.getStatus());
    }
}
