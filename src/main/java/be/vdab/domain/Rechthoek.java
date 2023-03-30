package be.vdab.domain;

import java.util.Objects;

public class Rechthoek {
    private int lengte;
    private int breedte;

    public Rechthoek(int lengte, int breedte) {

            setLengte(lengte);
            setBreedte(breedte);
        if (lengte < breedte) throw new IllegalArgumentException("Lengte moet groter dan breedte");
    }

    public void setLengte(int lengte) {
        if (lengte > 0) {
            this.lengte = lengte;
        } else {
            throw new IllegalArgumentException("Lengte moet positief zijn!");
        }
    }

    public void setBreedte(int breedte) {
        if (breedte > 0) {
            this.breedte = breedte;
        } else {
            throw new IllegalArgumentException("Breedte moet positief zijn!");
        }
    }

    public int getOppervlakte() {
        return breedte * lengte;
    }

    public int getOmtrek() {
        return 2 * (breedte + lengte);
    }

    @Override
    public boolean equals(Object o) {

        return o instanceof Rechthoek rechthoek && lengte == rechthoek.lengte && breedte == rechthoek.breedte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengte, breedte);
    }
}
