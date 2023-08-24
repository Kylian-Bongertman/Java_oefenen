package schonewinkel;

public class DurumDoner extends DonerProduct {
    DurumDoner(boolean isExtraGroot, Saus saus) {
        super(isExtraGroot, saus);
        if (isExtraGroot) {
            naam = "Durum doner mega";
            prijs = 7.0;
        } else {
            naam = "Durum doner";
            prijs = 4.5;
        }
        addSaus();
    }

    @Override
    public double getPrijs() {
        return prijs + getSausPrijs();
    }
}
