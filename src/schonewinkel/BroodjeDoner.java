package schonewinkel;

public class BroodjeDoner extends DonerProduct{


    @Override
    public double getPrijs() {
        double totaalPrijs = 0.0;
        totaalPrijs += 5;
        return totaalPrijs;
    }
}

