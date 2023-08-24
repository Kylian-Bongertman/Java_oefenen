package schonewinkel;

public class DonerProduct extends Product {
    protected boolean isExtraGroot;
    protected Saus saus;

    DonerProduct() {
        isExtraGroot = KassaMedewerker.getDonerGrootte();
        saus = KassaMedewerker.getSaus();
    }

    public boolean getIsExtraGroot() {
        return isExtraGroot;
    }

    public void setIsExtraGroot(boolean isExtraGroot) {
        this.isExtraGroot = isExtraGroot;
    }

    protected void addSaus() {
        prijs += saus.getPrijsSaus();
        naam += " | Saus: " + saus.getNaamSaus();
    }
}


