import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    public Store() {
    }

    public Product takeOrder(String productKeuze) {
        if(productKeuze.equals("BROODJE_DONER_")) {
            DonerProduct bestelling = new DonerProduct("Broodje doner");
            return bestelling;
        }
        else if(productKeuze.equals("DURUM_DONER_")) {
            DonerProduct bestelling = new DonerProduct("Durum doner");
            return bestelling;
        }
        else if(productKeuze.equals("COLA_")) {
            Drinken bestelling = new Drinken("Cola");
            return bestelling;
        }

//        else if(product.equals("Drinken")) {
//            Drinken bestelling = null;
//            bestelling = new Drinken();
//            return bestelling;
//        }
        return null;
    }
    protected String getProductKeuze() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kies het product:");
        String productKeuze = scanner.nextLine().toUpperCase();
        if(productKeuze.equals("BROODJE DONER")) { productKeuze = "BROODJE_DONER_"; }
        else if (productKeuze.equals("DURUM DONER")) { productKeuze = "DURUM_DONER_"; }
        else if (productKeuze.equals("COLA")) { productKeuze = "COLA_"; }
        return productKeuze;
    }

    public static void main(String[] args) {
        toonMenu();
        Scanner scanner = new Scanner(System.in);
        boolean isNieuweBestellingMaken = true;
        List<Product> bestelling = new ArrayList<>(); // Lijst voor bestelling
        Double totaalPrijsBestelling = 0.0;

        Store donerIX = new Store();

        while (isNieuweBestellingMaken) {
            String productKeuze = donerIX.getProductKeuze();
            Product nieuwItem = donerIX.takeOrder(productKeuze);

            System.out.println("Bedankt voor je bestelling, de prijs van dit item is: " + nieuwItem.getPrijs() + " Euro");
            bestelling.add(nieuwItem);
            System.out.println("Wil u nog wat bestellen? (y/n)");
            String nieuweBestellingKeuze = scanner.nextLine();
            if (nieuweBestellingKeuze.equals("y")) {
                isNieuweBestellingMaken = true;
            } else {
                isNieuweBestellingMaken = false;
            }
        }

        for(Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
        }
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + totaalPrijsBestelling + " Euro"); //Som van bestelling
    }

    private static void toonMenu() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner");
        System.out.println("Cola          |            ");
        System.out.println("--------------------------");
    }
}
