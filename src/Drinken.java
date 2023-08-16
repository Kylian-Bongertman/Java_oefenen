public class Drinken extends Product {
    Drinken(String productKeuze) {
       // String productKeuze = getProductKeuze(); //keuze uit: cola, de rest is uitverkocht
        kiesGrootte(productKeuze); // Normaal of Mega grootte
        maakProduct(); // product maken voor klant
    }

    private void maakProduct() {
        System.out.println("Hier is uw " + productGrootte.getNaam() + " uit de koelkast!");
    }

    @Override
    public Double getPrijs() {
        Double totaalPrijs = 0.0;
        totaalPrijs = productGrootte.getPrijs();
        return totaalPrijs;
    }

}

