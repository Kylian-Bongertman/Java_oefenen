import java.util.Scanner;

public class Product {
    protected Scanner scanner = new Scanner(System.in);
    protected ProductGrootte productGrootte = null;

    public Double getPrijs() {
        Double totaalPrijs = 0.0;
        return totaalPrijs;
    }

//    protected String getProductKeuze() {
//            System.out.println("Kies het product:");
//            String productKeuze = scanner.nextLine().toUpperCase();
//            if(productKeuze.equals("BROODJE DONER")) { productKeuze = "BROODJE_DONER_"; }
//            else if (productKeuze.equals("DURUM DONER")) { productKeuze = "DURUM_DONER_"; }
//            else if (productKeuze.equals("COLA")) { productKeuze = "COLA_"; }
//            return productKeuze;
//        }
    protected void kiesGrootte(String productKeuze) {
        System.out.println("Kies de grootte van de bestelling (Normaal/Mega):");
        String gekozenGrootteString = scanner.nextLine();
        ProductGrootte grootte = ProductGrootte.valueOf(productKeuze + gekozenGrootteString.toUpperCase()); //kan DURUM_DONER_ of BROODJE zijn afhankelijk van keuze
        setProductGrootte(grootte);
    }
    public void setProductGrootte(ProductGrootte productGrootte) {
        this.productGrootte = productGrootte;
    }
    }



//ieder product weet:
//een prijs
//een gebruikers input
//
//
//Ieder product doet:
//voorbereiding
//order aanmaken