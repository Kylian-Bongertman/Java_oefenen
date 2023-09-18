package kebabzaak;

public abstract class DonerProduct extends Product {
    protected boolean isExtraGroot;
    protected Saus saus;

    protected DonerProduct(boolean isExtraGroot, Saus saus) {
        this.isExtraGroot = isExtraGroot;
        this.saus = saus;
    }

    public double getPrijs() {
        return prijs + getSausPrijs();
    }

    public double getSausPrijs() {
        return saus.getPrijsSaus();
    }

    public String getSausNaam() {
        return saus.getNaamSaus();
    }
}


