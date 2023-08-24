package schonewinkel;

public class DonerProduct extends Product {
    protected boolean isExtraGroot;
    protected Saus saus;

    DonerProduct() {
        isExtraGroot = KassaMedewerker.getDonerGrootte();
        saus = KassaMedewerker.getSaus();
    }

    protected void addSaus() {
        prijs += saus.getPrijsSaus();
        naam += " | Saus: " + saus.getNaamSaus();
    }
}


