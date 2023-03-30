package be.vdab.domain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class IsbnTest {

    @ParameterizedTest
    @ValueSource (longs = {9789027439642L, 9789020429640L})
    void correcteIsbns (long nummer) {
        new Isbn(nummer);
    }

    @ParameterizedTest
    @ValueSource (longs =
            {9789027439640L, 9789027439643L, 97890274396422L, 978902743964L, 9779027439643L, -9789027439642L, 0L})
    void geenCorrecteIsbns (long nummer) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Isbn(nummer));
    }

    @Test void toStringGeeftHetNummerTerug () {
        assertThat(new Isbn(9789027439642L)).hasToString("9789027439642");
    }

}