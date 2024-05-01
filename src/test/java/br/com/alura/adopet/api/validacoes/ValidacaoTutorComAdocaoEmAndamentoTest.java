package br.com.alura.adopet.api.validacoes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@ExtendWith(MockitoExtension.class)
public class ValidacaoTutorComAdocaoEmAndamentoTest {
        
    @InjectMocks
    private ValidacaoTutorComAdocaoEmAndamento validador;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoTutorComAdocaoEmAndamento() {
        // Arrange

        BDDMockito.given(
                adocaoRepository.existsByTutorIdAndStatus(
                        dto.idTutor(),
                        StatusAdocao.AGUARDANDO_AVALIACAO))
                .willReturn(true);

        // ACt + Assert
        Assertions.assertThrows(ValidacaoException.class, () -> validador.validar(dto));
    }

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoTutorSemAdocaoEmAndamento() {
        // Arrange

        BDDMockito.given(
                adocaoRepository.existsByTutorIdAndStatus(
                        dto.idTutor(),
                        StatusAdocao.AGUARDANDO_AVALIACAO))
                .willReturn(false);

        // ACt + Assert
        Assertions.assertDoesNotThrow(() -> validador.validar(dto));
    }
}
