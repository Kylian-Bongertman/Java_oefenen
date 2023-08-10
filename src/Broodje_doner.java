public class Broodje_doner extends Bestelling implements Ingredient {
    private Saus saus = null;
    private ProductGrootte productGrootte = null;

    Broodje_doner() {

        //super(grootte);
    }

    @Override
    public Double getPrijs() {
        Double totaalPrijs = 0.0;
        totaalPrijs = productGrootte.getPrijs();
        totaalPrijs += saus.getPrijs();
        return totaalPrijs;
    }
    public Saus getSaus() {
        return saus;
    }
    public void setSaus(Saus gekozenSaus) {
        this.saus = gekozenSaus;
    }
    public void setProductGrootte(ProductGrootte productGrootte) {
        this.productGrootte = productGrootte;
    }
}

//Feature requests:
//Doner donderdag 1 euro korting