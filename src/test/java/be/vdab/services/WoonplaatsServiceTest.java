package be.vdab.services;

import be.vdab.repositories.PlaatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) class WoonplaatsServiceTest {
    @Mock private PlaatsRepository repository;
    private WoonplaatsService service;
    @BeforeEach
    void beforeEach() {
        service = new WoonplaatsService(repository);
    }

    @Test
    void bevatMax4Streepjes () {

        when(repository.findMetStreepjes()).thenReturn(Stream.of("Aische-en-Refail", "Annevoie-Rouillon",
                        "Appelterre-Eichem", "Arc-Wattripont", "Beveren-aan-de-IJzer", "Boussu-lez-Walcourt",
                        "Chaussée-Notre-Dame-Louvignies", "Corenne", "Corenne", "Christelijke Sociale Organisaties",
                        "Écaussinnes-d'Enghien", "Nil-Saint-Vincent-Saint-Martin")
                .filter(regel -> regel.contains("-"))
                .toList());
        assertThat(service.maxAantalStreepjesInEenWoonplaats()).isEqualTo(4L);
        verify(repository).findMetStreepjes();
    }

}