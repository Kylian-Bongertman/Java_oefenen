package schonewinkel;

import schonewinkel.Bezorgingen.BezorgDienst;
import schonewinkel.Bezorgingen.Bezorger;
import schonewinkel.Bezorgingen.Bezorging;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Winkel {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Product> bestelling = new ArrayList<>();
    private static final KassaMedewerker kassaMedewerker = new KassaMedewerker();
    private static final Bezorger bezorger = new Bezorger();
    private static final Locale locale = new Locale("en", "NL");
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    public static void main(String[] args) throws Exception {
        neemBestellingAan();
        kiesVerzendMethode();
        printKassaBon(bestelling);
    }

    private static void kiesVerzendMethode() {
        System.out.println("Wil je je bestelling thuis bezorgd hebben? (y/n)");
        String bestellingBezorgenKeuze = scanner.nextLine();

        boolean isAkkoordMetBezorging;
        if (bestellingBezorgenKeuze.equals("y")) {
            double bezorgTijd = BezorgDienst.berekenBezorgTijd();
            double bezorgPrijs = BezorgDienst.berekenBezorgPrijs(bestelling);
            System.out.println("De bezorgTijd is: " + bezorgTijd + " minuten. " + " De bezorgPrijs is: " + bezorgPrijs); //De verzendMethode is: .. Brief/ doos
            System.out.println("Is dit akkoord? (y/n)");
            String bezorgingAkkoordKeuze = scanner.nextLine();
            isAkkoordMetBezorging = bezorgingAkkoordKeuze.equals("y");

            if (isAkkoordMetBezorging) {
                Bezorging bezorgingVanBestelling = new Bezorging(bezorgTijd, bezorgPrijs);
                bestelling.add(bezorgingVanBestelling);
            }
        }
    }

    private static void neemBestellingAan() {
        boolean isNieuweBestelling = true;

        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");

        while (isNieuweBestelling) {
            toonMenu();
            Product nieuwItem = kassaMedewerker.voegProductToeAanBestelling();
            bestelling.add(nieuwItem);
            double nieuwItemPrijs = nieuwItem.getPrijs();
            System.out.println("De prijs van dit item is: " + currencyFormatter.format(nieuwItemPrijs));

            System.out.println("Wilt u nog wat bestellen? (y/n)");
            String nieuwItemInBestellingKeuze = scanner.nextLine();
            isNieuweBestelling = nieuwItemInBestellingKeuze.equals("y"); // Als gebruiker "y" antwoord → plaats nieuw product in bestelling
        }
    }


    private static void printKassaBon(List<Product> bestelling) throws Exception {
        double totaalPrijsBestelling = berekenTotaalPrijs(bestelling);
        Bezorging bezorging = vindBezorging(bestelling);

        System.out.println("--------------------Bestelling--------------------");
        for (Product item : bestelling) {
            printProduct(item);
        }
        System.out.println("--------------------------------------------------");

        if (bezorging != null) {
            System.out.println("De bezorging zal plaatsvinden over: " + bezorging.getBezorgTijd() + " minuten");
            stuurBezorger(bezorging.getBezorgTijd());
        }
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + currencyFormatter.format(totaalPrijsBestelling));
    }

    private static double berekenTotaalPrijs(List<Product> bestelling) {
        double totaalPrijsBestelling = 0.0;
        for (Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
        }
        return totaalPrijsBestelling;
    }

    private static Bezorging vindBezorging(List<Product> bestelling) {
        for (Product item : bestelling) {
            if (item instanceof Bezorging) {
                return (Bezorging) item;
            }
        }
        return null;
    }

    private static void stuurBezorger(double minutenOnderweg) throws Exception {
        bezorger.startBezorgAnimatie(minutenOnderweg);
    }

    private static void toonMenu() {
        System.out.println("----------------- Menu -----------------");
        System.out.println("Broodje doner | Durum doner             ");
        System.out.println("Cola          | Fanta       | Ranja     ");
        System.out.println("----------------------------------------");
    }

    private static void printProduct(Product item) {
        if (item instanceof DonerProduct) {
            DonerProduct donerProduct = (DonerProduct) item;
            String sausToevoeging = "| Saus: " + donerProduct.getSausNaam();
            System.out.println("Naam: " + item.getNaam() + " " + sausToevoeging + " | prijs: " + currencyFormatter.format(item.getPrijs()));
        } else {
            System.out.println("Naam: " + item.getNaam() + " | prijs: " + currencyFormatter.format(item.getPrijs()));
        }
    }
}
