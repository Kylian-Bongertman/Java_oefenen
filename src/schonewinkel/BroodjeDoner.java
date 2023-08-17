package schonewinkel;

public class BroodjeDoner extends DonerProduct{
    BroodjeDoner() {
        naam = "Broodje doner";
        prijs = 5.0;
    }

    @Override
    public double getPrijs() {
        return this.prijs;
    }
}

