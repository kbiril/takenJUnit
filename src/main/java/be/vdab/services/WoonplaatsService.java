package be.vdab.services;

import be.vdab.repositories.PlaatsRepository;

import java.util.Arrays;

public class WoonplaatsService {
private final PlaatsRepository repository;
    public WoonplaatsService (PlaatsRepository repository) {
        this.repository = repository;
    }
//
    public long maxAantalStreepjesInEenWoonplaats() {

        return repository.findMetStreepjes()
                         .stream()
                         .map(plaats -> Arrays.stream(plaats.split(""))
                                              .filter(letter -> letter.equals("-"))
                                              .count())
                         .max(Long::compare)
                         .orElse(0L);
    }
}
