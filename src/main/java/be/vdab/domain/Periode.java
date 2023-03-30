package be.vdab.domain;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Periode {
    private LocalDate van;
    private LocalDate tot;

    public Periode(LocalDate van, LocalDate tot) {

        if (tot.compareTo(van) >= 0) {
            this.tot = tot;
            this.van = van;
        } else throw new IllegalArgumentException();
    }

    public boolean komtNa (Periode periode) {

        if(!periode.equals(null)) {
            return van.isAfter(periode.tot);
        } else throw new NullPointerException();
    }

    public boolean overlapMet (Periode periode) {
        return tot.compareTo(periode.van) >= 0 && van.compareTo(periode.tot) <= 0;
    }
}
