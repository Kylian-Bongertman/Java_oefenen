public class Drinken extends Product {
    Drinken(String productKeuze) {
       // String productKeuze = getProductKeuze(); //keuze uit: cola, de rest is uitverkocht
        kiesGrootte(productKeuze); // Normaal of Mega grootte
        maakProduct(productKeuze); // product maken voor klant
    }

    private void maakProduct(String productKeuze) {
        System.out.println("Hier is uw " + productKeuze + " uit de koelkast!");
    }

    @Override
    public Double getPrijs() {
        Double totaalPrijs = 0.0;
        return totaalPrijs;
    }

}

