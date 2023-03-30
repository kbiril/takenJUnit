package be.vdab.domain;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ArtikelTest {
    @Test
    @DisplayName("Prijs - 1000, BTW - 21 %, Prijs inclusief BTW - 1210")
    void prijs1000Btw21PrijsIncBtw1210 () {
        assertThat(new Artikel(BigDecimal.valueOf(1000), BigDecimal.valueOf(21)).getPrijsInclusiefBtw())
                                                                 .isEqualByComparingTo("1210");
    }
}
