package be.vdab.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


class VeilingTest {
    private Veiling veiling;

    @BeforeEach
    void beforeEach() {
        veiling = new Veiling();
    }
    @Test
    @DisplayName("Voor een nieuwe veiling de bod is 0€")
    void voorNieuweVeilingDeBodIs0€() {
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    @DisplayName("Als je het eerste bod uitvoert, het hoogste bod gelijk is aan het bedrag van dit bod")
    void alsJeEersteBodUitvoertHoogsteBodIsDitBedrag() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("1000");
    }

    @Test
    @DisplayName("Als je meerdere bods uitvoert, het hoogste bod gelijk is aan het hoogste bedrag van de bods")
    void alsJeMeerdereBodUitvoertHoogsteBodIsHoogstBedrag() {
        veiling.doeBod(BigDecimal.valueOf(1000));
        veiling.doeBod(BigDecimal.valueOf(2000));
        veiling.doeBod(BigDecimal.valueOf(300));
        veiling.doeBod(BigDecimal.valueOf(4000));
        veiling.doeBod(BigDecimal.valueOf(3500));
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo("4000");
    }


}