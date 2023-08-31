package schonewinkel.Bezorgingen;

import schonewinkel.Product;

public class Bezorging extends Product {
    private double bezorgTijd;

    public Bezorging(double bezorgTijd, double bezorgPrijs) {
        this.bezorgTijd = bezorgTijd;
        prijs = bezorgPrijs;
        naam = "Bezorging";
    }

    public double getBezorgTijd() {
        return bezorgTijd;
    }

}
