package schonewinkel;

public class DonerProduct extends Product {
    protected boolean isExtraGroot;
    protected Saus saus;

    protected DonerProduct(boolean isExtraGroot, Saus saus) {
        this.isExtraGroot = isExtraGroot;
        this.saus = saus;
    }

    protected void addSaus() {
        prijs += saus.getPrijsSaus();
        naam += " | Saus: " + saus.getNaamSaus();
    }

    public double getPrijs() {
        return saus.getPrijsSaus();
    }

    public double getSausPrijs() {
        return saus.getPrijsSaus();
    }

    public String getSausNaam() {
        return saus.getNaamSaus();
    }
}


