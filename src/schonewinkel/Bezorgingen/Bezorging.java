package schonewinkel.Bezorgingen;

import schonewinkel.Product;

public class Bezorging extends Product {
    private final double bezorgTijd;
    private final String bezorgMethode;


    public Bezorging(double bezorgTijd, double bezorgPrijs, String bezorgMethode) {
        this.bezorgTijd = bezorgTijd;
        this.bezorgMethode = bezorgMethode;
        prijs = bezorgPrijs;
        naam = "Bezorging";
        volume = 0;
    }

    public double getBezorgTijd() {
        return bezorgTijd;
    }

    public String getBezorgMethode() {
        return bezorgMethode;
    }
}
