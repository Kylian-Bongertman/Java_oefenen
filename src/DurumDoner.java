//public class DurumDoner extends DonerProduct implements Ingredient {
//    private Saus saus = null;
//    private ProductGrootte productGrootte = null;
//    private Salade[] salades = new Salade[3];
//    private int saladeCount = 0;
//
//    DurumDoner() {
//    }
//
//    @Override
//    public Double getPrijs() {
//        Double totaalPrijs = 0.0;
//        totaalPrijs = productGrootte.getPrijs();
//        totaalPrijs += saus.getPrijs();
//        return totaalPrijs;
//    }
//    public Saus getSaus() {
//        return saus;
//    }
//
//    public void setSaus(Saus gekozenSaus) {
//        this.saus = gekozenSaus;
//    }
//
//    public ProductGrootte getProductGrootte() {
//        return productGrootte;
//    }
//
//    public void setProductGrootte(ProductGrootte productGrootte) {
//        this.productGrootte = productGrootte;
//    }
//
//    public void addSalade(Salade salade) {
//        this.salades[saladeCount] = salade;
//        saladeCount++;
//    }
//
//    public String getSalades() {
//        String saladeString = "";
//        for(Salade salade : salades) {
//            saladeString += salade.name();
//        }
//        return saladeString;
//    }
//}

