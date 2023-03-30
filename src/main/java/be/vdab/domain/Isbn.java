package be.vdab.domain;

import static java.lang.Integer.parseInt;

public class Isbn {

    private long nummer;
    public Isbn(long nummer) {
        this.nummer = nummer;
        isIsbnValid();
    }

    @Override
    public String toString() {
        return String.valueOf(nummer);
    }

    private void isIsbnValid () {

        if (nummer == 0L) throw new IllegalArgumentException("nummer mag niet 0 zijn!");

        String nummerStr = String.valueOf(nummer);
        if (nummerStr.length() != 13) throw new IllegalArgumentException("Nummer moet 13 x cijfers bevatten!");

        if (!nummerStr.startsWith("978") && !nummerStr.startsWith("979")) {
           throw new IllegalArgumentException("Nummer moet met 978 of 979 beginnen!");
        }

        var cijfersVanNummer = nummerStr.split("");
        int index = 1;
        int somOnevenCijfers = 0;
        int somEvenCijfers = 0;
        for (var cijferStr : cijfersVanNummer) {
            int cijfer = parseInt(cijferStr);

            if (index % 2 == 0) {
                somEvenCijfers = somEvenCijfers + cijfer;
            } else {
                somOnevenCijfers = somOnevenCijfers + cijfer;
            }
            index++;
        }
        int laatsteCijfer = parseInt(cijfersVanNummer[12]);
        somOnevenCijfers -= laatsteCijfer;

        int controleGetal = somOnevenCijfers + (somEvenCijfers * 3);
        int dichtsHoger10Tal = controleGetal - controleGetal % 10 + 10;
        int laatsteCijferControle;

        laatsteCijferControle = dichtsHoger10Tal - controleGetal == 10 ? 0 : dichtsHoger10Tal - controleGetal;

        if (laatsteCijferControle != laatsteCijfer) {
            throw new IllegalArgumentException("Laatste cijfer is verkeerd!");
        }

    }
}
