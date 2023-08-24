package schonewinkel;

public class SausOpties {
    static String[] beschikbareSauzen = {"Knoflook Saus", "Sambal", "Chilisaus", "Geen Saus"};
    static Double[] prijsSauzen = {0.3, 0.4, 0.5, 0.0};

    public static String[] getBeschikbareSauzen() {
        return beschikbareSauzen;
    }

    public static Double[] getPrijsSauzen() {
        return prijsSauzen;
    }
}