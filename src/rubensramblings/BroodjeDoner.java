package rubensramblings;

public class BroodjeDoner extends DonerProduct{
    public BroodjeDoner(Double prijs, boolean isExtraGroot) {
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
