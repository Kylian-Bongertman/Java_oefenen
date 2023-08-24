package schonewinkel;

public class SausMenu {
    static String[] sausNamen = {"Knoflook Saus", "Sambal", "Chilisaus", "Geen Saus", "Extra Sambal"};
    static Double[] sausPrijzen = {0.3, 0.4, 0.5, 0.0, 1.0};

    public static String[] getSausNamen() {
        return sausNamen;
    }

    public static Double[] getSausPrijzen() {
        return sausPrijzen;
    }
}