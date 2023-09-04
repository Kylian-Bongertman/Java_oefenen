package schonewinkel.Bezorgingen;

import schonewinkel.Product;

public class Bezorging extends Product {
    private final double bezorgTijd;

    public Bezorging(double bezorgTijd, double bezorgPrijs) {
        this.bezorgTijd = bezorgTijd;
        prijs = bezorgPrijs;
        naam = "Bezorging";
        volume = 0;
    }

    public double getBezorgTijd() {
        return bezorgTijd;
    }

}
