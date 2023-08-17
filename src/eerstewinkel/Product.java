package eerstewinkel;

import java.util.Scanner;

public class Product {
    protected Scanner scanner = new Scanner(System.in);
    protected ProductGrootte productGrootte = null;

    public Double getPrijs() {
        Double totaalPrijs = 0.0;
        return totaalPrijs;
    }

    protected void kiesGrootte(String productKeuze) {
        System.out.println("Kies de grootte van de bestelling (Normaal/Mega):");
        String gekozenGrootteString = scanner.nextLine().toUpperCase();
        ProductGrootte grootte = ProductGrootte.valueOf(productKeuze + gekozenGrootteString); //kan DURUM_DONER_ of BROODJE zijn afhankelijk van keuze
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