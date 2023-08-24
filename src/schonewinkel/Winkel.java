package schonewinkel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Winkel {

    public static void main(String[] args) {
        List<Product> bestelling = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isNieuweBestelling = true;
        KassaMedewerker Tycho = new KassaMedewerker();

        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");

        while (isNieuweBestelling) {
            toonMenu();
            Product nieuwItem = Tycho.neemBestellingAan();
            bestelling.add(nieuwItem);
            double nieuwItemPrijs = nieuwItem.getPrijs();
            System.out.println("De prijs van dit item is: " + nieuwItemPrijs);

            System.out.println("Wilt u nog wat bestellen? (y/n)");
            String nieuweBestellingKeuze = scanner.nextLine();
            isNieuweBestelling = nieuweBestellingKeuze.equals("y"); // Als gebruiker "y" antwoord → plaats nieuwe bestelling
        }
        printKassaBon(bestelling);
    }

    private static void printKassaBon(List<Product> bestelling) {
        Double totaalPrijsBestelling = 0.0;

        System.out.println("--------------------Bestelling--------------------");
        for (Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
            if (item instanceof DonerProduct) {
                DonerProduct donerProduct = (DonerProduct) item;
                String sausToevoeging = "| Saus:" + donerProduct.getSausNaam();
                System.out.println("Naam: " + item.getNaam() + " " + sausToevoeging + " | prijs: " + item.getPrijs());
            } else {
                System.out.println("Naam: " + item.getNaam() + " | prijs: " + item.getPrijs());
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + totaalPrijsBestelling + " Euro"); //Som van bestelling
    }

    public static void toonMenu() {
        System.out.println("----------------- Menu -----------------");
        System.out.println("Broodje doner | Durum doner             ");
        System.out.println("Cola          | Fanta       | Ranja     ");
        System.out.println("----------------------------------------");
    }
}
