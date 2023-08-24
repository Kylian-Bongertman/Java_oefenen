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

    public double getPrijs(){
        return saus.getPrijsSaus();
    }

    public double getSausPrijs(){return saus.getPrijsSaus();}

    public String getSausNaam(){return saus.getNaamSaus();}
}


