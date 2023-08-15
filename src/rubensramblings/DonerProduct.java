package rubensramblings;

public class DonerProduct extends Product{
    private boolean isExtraGroot;

    public DonerProduct(Double prijs, boolean isExtraGroot) {
        super(prijs);
        this.isExtraGroot = isExtraGroot;
    }

    public boolean isExtraGroot() {
        return isExtraGroot;
    }

    @Override
    public Double getPrijs() {
        Double standaardPrijs = super.getPrijs();
        boolean extraGroot = isExtraGroot();
        if (extraGroot){
            return standaardPrijs * 1.5;
        }
        return standaardPrijs;
    }
}
