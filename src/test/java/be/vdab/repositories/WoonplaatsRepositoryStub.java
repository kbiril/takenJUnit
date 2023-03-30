package be.vdab.repositories;

import java.util.List;
import java.util.stream.Stream;

public class WoonplaatsRepositoryStub extends TxToonPlaatsRepository {
    @Override
    public List<String> findMetStreepjes() {
        return Stream.of("Aische-en-Refail", "Annevoie-Rouillon", "Appelterre-Eichem", "Arc-Wattripont",
                         "Beveren-aan-de-IJzer", "Boussu-lez-Walcourt", "Chaussée-Notre-Dame-Louvignies", "Corenne",
                         "Corenne", "Christelijke Sociale Organisaties", "Écaussinnes-d'Enghien",
                         "Nil-Saint-Vincent-Saint-Martin")
                      .filter(regel -> regel.contains("-"))
                      .toList();
    }
}
