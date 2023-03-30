package be.vdab.domain;

public class WoordenTeller {
    public int woordenTeller (String zin) {
        int teller = 0;

        zin = spacesRemover(zin);

        if (zin.length() != 0) {
            var woorden = zin.split(" ");

            for (String woord : woorden) {
                woord = woord.strip();
                var words = woord.split(",");
                for (var word : words) {
                    if (!word.isBlank()) {
                        teller++;
                    }
                }
            }
        }
        return teller;
    }

    private static String spacesRemover(String text) {
        text = text.strip();
        while (text.contains("  ")) {
            text = text.replace("  ", " ");
        }
        return text;
    }

}
