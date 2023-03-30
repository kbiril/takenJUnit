package be.vdab.domain;

public class Woord {
    private String woord;

    public Woord(String woord) {
        setWoord(woord);
    }

    public String getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        if (!woord.isBlank()) {
            this.woord = woord;
        } else throw new IllegalArgumentException("Woord is niet ingevuld!");
    }

    public boolean isPalindroom() {
        if (!woord.isBlank()) {
            StringBuilder woordSB = new StringBuilder(woord);
            return woordSB.reverse().toString().equalsIgnoreCase(woord);
        } else {
            throw new IllegalArgumentException("String is leeg");

        }

    }
}
