package schonewinkel;

public abstract class DonerProduct extends Product {
    protected boolean isExtraGroot;
    protected Saus saus;

    protected DonerProduct(boolean isExtraGroot, Saus saus) {
        this.isExtraGroot = isExtraGroot;
        this.saus = saus;
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


