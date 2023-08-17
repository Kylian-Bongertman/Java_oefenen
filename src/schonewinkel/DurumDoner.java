package schonewinkel;

public class DurumDoner extends DonerProduct{


    @Override
    public double getPrijs() {
        double totaalPrijs = 0.0;
        totaalPrijs += 4.5;
        return totaalPrijs;
    }
}
