package schonewinkel.Bezorgingen;

import schonewinkel.Product;

public class Bezorging extends Product {
    private double bezorgTijd;
    private double bezorgPrijs;

    public Bezorging(double bezorgTijd, double bezorgPrijs) {
        this.bezorgTijd = bezorgTijd;
        this.bezorgPrijs = bezorgPrijs;
        naam = "Bezorging";
        prijs = 0.0;
    }

    public double getBezorgTijd() {
        return bezorgTijd;
    }

    public double getBezorgPrijs() {
        return bezorgPrijs;
    }

}
