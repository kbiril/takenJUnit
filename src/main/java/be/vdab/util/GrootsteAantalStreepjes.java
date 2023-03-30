package be.vdab.util;

import be.vdab.exceptions.RepositoryException;
import be.vdab.repositories.JdbcWoonplaatsRepository;
import be.vdab.repositories.PlaatsRepository;
import be.vdab.repositories.TxToonPlaatsRepository;
import be.vdab.services.WoonplaatsService;

import java.util.Scanner;

public class GrootsteAantalStreepjes {
    public static void main(String[] args) {
        System.out.println("1 - woonplaatsen.txt, 2 - data base");
        var scanner = new Scanner(System.in);
        var keuze = scanner.nextInt();

        while (keuze != 1 && keuze != 2) {
            System.out.println("Verkeerde keuze, probeer opnieuw: ");
            keuze = scanner.nextInt();
        }

        PlaatsRepository repository = keuze == 1 ? new TxToonPlaatsRepository() : new JdbcWoonplaatsRepository();
        try {
            var service = new WoonplaatsService(repository);
            System.out.println(service.maxAantalStreepjesInEenWoonplaats());
        } catch (RepositoryException ex) {
            System.out.println("Kan woonplaatsen niet lezen");
            ex.printStackTrace(System.err);
        }
    }
}
