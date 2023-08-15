package rubensramblings;

public class BroodjeDonerRamblings extends DonerProduct{
    public BroodjeDonerRamblings(Double prijs, boolean isExtraGroot) {
        super(prijs, isExtraGroot);
    }

    @Override
    public Double getPrijs() {
        Double standaardPrijs = super.getPrijs();
        boolean extraGroot = isExtraGroot();
        if (extraGroot){
            return standaardPrijs * 1.2;
        }
        return standaardPrijs;
    }
}
