package be.vdab.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class RechthoekTest {

    @Test
    @DisplayName("een Oppervlakte van de rechthoek met zijden: 6 en 4 is 24")
    void eenOppvlkVan4en6Rechthoek() {

        assertThat(new Rechthoek(6, 4).getOppervlakte()).isEqualTo(24);
    }
    @Test
    @DisplayName("een Omtrek van de rechthoek met zijden: 6 en 4 is 20")
    void eenOmtrekVan4en6Rechthoek() {

        assertThat(new Rechthoek(6, 4).getOmtrek()).isEqualTo(20);
    }

    @Test
    @DisplayName("Rechthoeken met dezelfde zijden, zijn gelijk")
    void rechthoekenMetDezelfdeZijdenZijnGelijk () {
        assertThat(new Rechthoek(6, 4)).isEqualTo(new Rechthoek(6,4));
    }

    @Test
    @DisplayName("Rechthoeken met verschillende zijden, zijn verschillend")
    void rechthoekenMetVerschillendeZijdenZijnVerschillend () {
        assertThat(new Rechthoek(6, 4)).isNotEqualTo(new Rechthoek(5,4));
    }

    @Test
    @DisplayName("Gelijke rechthoeken hebben dezelfde HashCode")
    void gelijkeRechthoekenHebbenDezelfdeHashCode () {
        assertThat(new Rechthoek(7, 6)).hasSameHashCodeAs(new Rechthoek(7,6));
    }

    @Test
    @DisplayName("Lengte moet groter dan breedte")
    void lengteMoetGroterDanBreedte () {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(6,7));
    }

    @Test
    @DisplayName("Lengte moet positief zijn")
    void lengteMoetPositiefZijn () {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(-3, 4));
    }

    @Test
    @DisplayName("Breedte moet positief zijn")
    void breedteMoetPositiefZijn () {
        assertThatIllegalArgumentException().isThrownBy(() -> new Rechthoek(3, -1));
    }


}
