package schonewinkel;

public class DurumDoner extends DonerProduct{
    DurumDoner() {
        if(isExtraGroot) {
            naam = "Durum doner mega";
            prijs = 7.0;
        }
        else {
            naam = "Durum doner";
            prijs = 4.5;
        }
    }

    @Override
    public double getPrijs() {
        return this.prijs;
    }
}
