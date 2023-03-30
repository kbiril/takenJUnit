package be.vdab.domain;

import java.math.BigDecimal;

public class Veiling {

    private BigDecimal bod = BigDecimal.ZERO;
    public void doeBod(BigDecimal bedrag) {
        if (bod.compareTo(bedrag) < 0) {
            bod = bedrag;
        }
    }

    public BigDecimal getHoogsteBod() {
        return bod;
    }
}
