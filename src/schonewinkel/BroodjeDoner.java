package schonewinkel;

public class BroodjeDoner extends DonerProduct {
    public BroodjeDoner(boolean isExtraGroot, Saus saus) {
        super(isExtraGroot, saus);
        if (isExtraGroot) {
            naam = "Broodje doner mega";
            prijs = 8.0;
        } else {
            naam = "Broodje doner";
            prijs = 5.0;
        }
        addSaus();
    }

    @Override
    public double getPrijs() {
        return prijs + getSausPrijs();
    }
}

