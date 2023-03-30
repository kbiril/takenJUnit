package be.vdab.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class WoordenTellerTest {
    private WoordenTeller teller;
    @BeforeEach
    void beforeEach() { teller = new WoordenTeller();}

    @Test
    void eenNullWaardeKanNiet() {
        assertThatNullPointerException().isThrownBy(() -> teller.woordenTeller(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ", ", "    ", ",", ",,,", ",,   ,,"})
    void bevat0Woorden(String string) {
        assertThat(teller.woordenTeller(string)).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"kat", "     kat", "kat    ", "    kat    ", " , kat, "})
    void bevat1Woord(String string) {
        assertThat(teller.woordenTeller(string)).isOne();
    }

    @ParameterizedTest
    @ValueSource(strings = {"kat springt", "kat,springt ", ", kat , springt", " , kat. spring: ", ",kat,springt "})
    void bevat2Woorden (String string) {
        assertThat(teller.woordenTeller(string)).isEqualTo(2);
    }

}