package be.vdab.repositories;
import be.vdab.exceptions.RepositoryException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxToonPlaatsRepository implements PlaatsRepository {
    private static final Path PATH = Path.of(
            "/Users/kbiri/Documents/JAVA_VDAB/JavaOntwikkelaar/JUnit/woonplaatsen.txt");
    @Override
    public List<String> findMetStreepjes() {
        try (var stream = Files.lines(PATH)){
            return stream.filter(regel -> regel.contains("-"))
                         .toList();
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }
}
