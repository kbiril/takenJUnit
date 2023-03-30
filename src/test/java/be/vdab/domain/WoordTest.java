package be.vdab.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class WoordTest {
    @Test
    void lepelIsPalindroom() {
        assertThat(new Woord("lepel").isPalindroom()).isTrue();
    }
    @Test
    void ymerimmiremyIsPalindroom() {
        assertThat(new Woord("ymerimmiremy").isPalindroom()).isTrue();
    }

    @Test
    void usaGeenPalindroom() {
        assertThat(new Woord("USA").isPalindroom()).isFalse();
    }
    @Test
    void belgieGeenPalindroom() {
        assertThat(new Woord("België").isPalindroom()).isFalse();
    }
//    @Test
//    void legeStrIsNull() {
//        assertThat(new Woord("").isPalindroom()).isNull();
//    }
}
