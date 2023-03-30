package be.vdab.repositories;

import be.vdab.exceptions.RepositoryException;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcWoonplaatsRepository extends AbstractRepository implements PlaatsRepository{
    @Override
    public List<String> findMetStreepjes() {
        try {
            var plaatsen = new ArrayList<String>();
            String sql = """
                            select naam
                            from woonplaatsen 
                            where naam like '%-%'
                         """;
            try (var connection = super.getConnection();
                 var statement = connection.prepareStatement(sql))
            {
               for (var result = statement.executeQuery(); result.next(); ) {
                   plaatsen.add(result.getString("naam"));
               }
            }
            return plaatsen;
        } catch (SQLException ex) {
            throw new RepositoryException(ex);
        }
    }
}
