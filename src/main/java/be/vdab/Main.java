package be.vdab;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String zin = "  *  kat   *  *    ";
        System.out.println(spacesRemover(zin));
        zin = ", ,   ,     .";
        zin = spacesRemover(zin);
        var stukjes = zin.split(" ");
        for (var stuk : stukjes) {
            stuk = stuk.strip();
            System.out.println(stuk);
        }
    }
    private static String spacesRemover(String text) {
        text = text.strip();
        while (text.contains("  ") || text.contains(",") || text.contains(".") || text.contains(":")) {
            text = text.replace("  ", " ");
            text = text.replace(";", "");
            text = text.replace(",", "");
            text = text.replace(".", "");

        }
        return text;
    }
}