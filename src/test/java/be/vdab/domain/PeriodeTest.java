package be.vdab.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

class PeriodeTest {
    private Periode periodeVan29OktTot10Nov;
    private Periode periodeVan11NovTot15Nov;
    private Periode periodeVan10NovTot15Nov;
    private Periode periodeVan28OktTot11Nov;
    private Periode periodeVan28OktTot10Nov;
    private Periode periodeVan15OktTot28Okt;
    private Periode periodeVan10NovTot11Nov;
    private Periode periodeVan10NovTot10Nov;
    LocalDate date29Okt2022 = LocalDate.of(2022, 10, 29);
    LocalDate date10Nov2022 = LocalDate.of(2022, 11, 10);
    LocalDate date11Nov2022 = LocalDate.of(2022, 11, 11);
    LocalDate date15Nov2022 = LocalDate.of(2022, 11, 15);
    LocalDate date28Okt2022 = LocalDate.of(2022, 10, 28);
    LocalDate date15Okt2022 = LocalDate.of(2022, 10, 15);
    @BeforeEach
    void beforeEach() {
        periodeVan29OktTot10Nov = new Periode(date29Okt2022, date10Nov2022);
        periodeVan11NovTot15Nov = new Periode(date11Nov2022, date15Nov2022);
        periodeVan10NovTot15Nov = new Periode(date10Nov2022, date15Nov2022);
        periodeVan28OktTot11Nov = new Periode(date28Okt2022, date11Nov2022);
        periodeVan28OktTot10Nov = new Periode(date28Okt2022, date10Nov2022);
        periodeVan15OktTot28Okt = new Periode(date15Okt2022, date28Okt2022);
        periodeVan10NovTot11Nov = new Periode(date10Nov2022, date11Nov2022);
        periodeVan10NovTot10Nov = new Periode(date10Nov2022, date10Nov2022);
    }

    @Test
    void vanMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(() -> new Periode(null, date28Okt2022));
    }
    @Test
    void totMoetIngevuldZijn() {
        assertThatNullPointerException().isThrownBy(() -> new Periode(date28Okt2022, null));
    }
    @Test
    void totMagNietKleinerDanVan () {
        assertThatIllegalArgumentException().isThrownBy(() -> new Periode(date28Okt2022, date15Okt2022));
    }
    @Test
    void periodeVan1DagisOk () {
        new Periode(date28Okt2022, date28Okt2022);
    }

    @Test
    void d11NovTot15NovkomtNa29OktPeriodeIsTrue() {
        assertThat(periodeVan11NovTot15Nov.komtNa(periodeVan29OktTot10Nov)).isTrue();
    }
    @Test
    void van29OktTot10NovKomtNa29OktTot10NovPeriodeIsFalse() {
        assertThat(periodeVan29OktTot10Nov.komtNa(periodeVan29OktTot10Nov)).isFalse();
    }

    @Test
    void van29OktTot10NovKomtNaVan28OktTot11NovPeriodeIsFalse() {
        assertThat(periodeVan29OktTot10Nov.komtNa(periodeVan28OktTot11Nov)).isFalse();
    }

    @Test
    void van15OktTot28OktKomtNaVan28OktTot11NovPeriodeIsFalse() {
        assertThat(periodeVan15OktTot28Okt.komtNa(periodeVan28OktTot11Nov)).isFalse();
    }
    @Test
    void vanNullKomtNaPeriodeIsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> periodeVan15OktTot28Okt.komtNa(null));
    }
    @Test
    void van11NovTot15NovOverlapMetVan10NovTot15NovIsTrue () {
        assertThat(periodeVan11NovTot15Nov.overlapMet(periodeVan10NovTot15Nov)).isTrue();
    }
    @Test
    void van10NovTot15NovOverlapMetVan11NovTot15NovIsTrue () {
        assertThat(periodeVan10NovTot15Nov.overlapMet(periodeVan11NovTot15Nov)).isTrue();
    }

    @Test
    void van10NovTot10NovOverlapMetVan10NovTot11NovIsTrue () {
        assertThat(periodeVan10NovTot10Nov.overlapMet(periodeVan10NovTot11Nov)).isTrue();
    }
    @Test
    void van10NovTot11NovOverlapMetVan10NovTot11NovIsTrue () {
        assertThat(periodeVan10NovTot11Nov.overlapMet(periodeVan10NovTot11Nov)).isTrue();
    }

    @Test
    void van10NovTot11NovOverlapMetVan10NovTot10NovIsTrue () {
        assertThat(periodeVan10NovTot11Nov.overlapMet(periodeVan10NovTot10Nov)).isTrue();
    }

    @Test
    void van10NovTot11NovOverlapMetVan15OktTot28OktIsFalse() {
        assertThat(periodeVan10NovTot11Nov.overlapMet(periodeVan15OktTot28Okt)).isFalse();
    }
    @Test
    void van29OktTot10NovOverlapMetVan15OktTot28OktIsFalse() {
        assertThat(periodeVan29OktTot10Nov.overlapMet(periodeVan15OktTot28Okt)).isFalse();
    }
    @Test
    void van29OktTot10NovOverlapMetVanNullException() {
        assertThatIllegalArgumentException().isThrownBy(() -> periodeVan29OktTot10Nov.overlapMet(null));
    }

}