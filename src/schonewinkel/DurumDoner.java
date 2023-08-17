package schonewinkel;

public class DurumDoner extends DonerProduct{
    DurumDoner() {
        naam = "Durum doner";
        prijs = 4.5;
    }

    @Override
    public double getPrijs() {
        return this.prijs;
    }
}
