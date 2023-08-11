import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    public Store() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner ");
        System.out.println("--------------------------");
    }

    public DonerProduct takeOrder() {
        DonerProduct bestelling = null;
        bestelling = new DonerProduct();
        return bestelling;


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

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nieuweBestellingMaken = true;
        List<DonerProduct> bestellingen = new ArrayList<>(); // Lijst voor bestellingen
        Double totaalPrijsBestellingen = 0.0;

        Store donerIX = new Store();

        while (nieuweBestellingMaken == true) {
            DonerProduct kylianbestelling = donerIX.takeOrder();

            System.out.println("Bedankt voor je bestelling, de tussentijdse prijs is: " + kylianbestelling.getPrijs() + " Euro");
            bestellingen.add(kylianbestelling);
            System.out.println("Wil u nog wat bestellen? (y/n)");
            String nieuweBestellingKeuze = scanner.nextLine();
            if (nieuweBestellingKeuze.equals("y")) {
                nieuweBestellingMaken = true;
            } else {
                nieuweBestellingMaken = false;
            }
        }

        for(DonerProduct bestelling : bestellingen) {
            totaalPrijsBestellingen += bestelling.getPrijs();
        }
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + totaalPrijsBestellingen + " Euro"); //Som van bestellingen
    }
}
