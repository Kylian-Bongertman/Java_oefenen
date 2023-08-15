import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    public Store() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner");
        System.out.println("Cola          |            ");
        System.out.println("--------------------------");
    }

    public DonerProduct takeOrder(String product) {

        if(product.equals("DonerProduct")) {
            DonerProduct bestelling;
            bestelling = new DonerProduct();
            return bestelling;
        }
//        else if(product.equals("Drinken")) {
//            Drinken bestelling = null;
//            bestelling = new Drinken();
//            return bestelling;
//        }

//        if (product.equals("Broodje doner")) {
//            bestelling = new DonerProduct("BROODJE_DONER_");
//            return bestelling;
//
//        } else if (product.equals("Durum doner")) {
//            bestelling = new DonerProduct("DURUM_DONER_");
//            return bestelling;
//        }

        // Voeg hier andere mogelijke producten toe
//        return new DonerProduct("");
return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nieuweBestellingMaken = true;
        List<DonerProduct> bestelling = new ArrayList<>(); // Lijst voor bestelling
        Double totaalPrijsBestelling = 0.0;

        Store donerIX = new Store();

        while (nieuweBestellingMaken) {
            DonerProduct kylianbestelling = donerIX.takeOrder("DonerProduct");

            System.out.println("Bedankt voor je bestelling, de tussentijdse prijs is: " + kylianbestelling.getPrijs() + " Euro");
            bestelling.add(kylianbestelling);
            System.out.println("Wil u nog wat bestellen? (y/n)");
            String nieuweBestellingKeuze = scanner.nextLine();
            if (nieuweBestellingKeuze.equals("y")) {
                nieuweBestellingMaken = true;
            } else {
                nieuweBestellingMaken = false;
            }
        }

        for(DonerProduct item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
        }
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + totaalPrijsBestelling + " Euro"); //Som van bestelling
    }
}
