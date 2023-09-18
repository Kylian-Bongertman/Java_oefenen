package kebabzaak;

public class FrisdrankMenu {
    private static final String[] frisdrankNamen = {"Cola", "Fanta", "Ranja"};
    private static final Double[] frisdrankPrijzen = {3.0, 2.0, 1.0};

    public static String[] getFrisdrankNamen() {
        return frisdrankNamen;
    }

    public static Double[] getFrisdrankPrijzen() {
        return frisdrankPrijzen;
    }
}
