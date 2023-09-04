package schonewinkel;

import schonewinkel.Bezorgingen.Bezorger;
import schonewinkel.Bezorgingen.Bezorging;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Winkel {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Product> bestelling = new ArrayList<>();
    private static final KassaMedewerker kassaMedewerker = new KassaMedewerker();
    private static final Bezorger bezorger = new Bezorger();
    private static final Locale locale = new Locale("en", "NL");
    public static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    public static void main(String[] args) {
        neemBestellingAan();
        verwerkKortingCode();
        verwerkVerzendMethode();
        printKassaBon();
        verstuurBezorging();
    }

    private static void verstuurBezorging() {
        Bezorging bezorging = vindBezorging(); //Haalt bezorging object uit de bestelling

        if (bezorging != null) {
            System.out.println("De bezorging zal plaatsvinden over: " + bezorging.getBezorgTijd() + " minuten");
            startBezorgAnimatie(bezorging.getBezorgTijd());
        }
    }

    private static void verwerkKortingCode() {
        int kortingPercentage = kassaMedewerker.vraagKortingCode(scanner);
        geefKorting(kortingPercentage);
        System.out.println("De korting is toegepast.");
    }

    private static void geefKorting(int kortingPercentage) {
        double percentageVanOrigineelPrijs;
        percentageVanOrigineelPrijs = (100 - kortingPercentage);
        for (Product item : bestelling) {
            double nieuwPrijs = item.getPrijs() * (percentageVanOrigineelPrijs / 100);
            item.setPrijs(nieuwPrijs);
        }
    }

    private static void verwerkVerzendMethode() {
        Bezorging bezorging = kassaMedewerker.vraagVerzendMethode(scanner, bestelling);
        if(bezorging != null) {
            bestelling.add(bezorging);
        }
    }

    private static void neemBestellingAan() {
        boolean isNieuweBestelling = true;

        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");

        while (isNieuweBestelling) {
            toonMenu();
            Product nieuwItem = kassaMedewerker.vraagTeBestellenProduct(scanner);
            bestelling.add(nieuwItem);
            double nieuwItemPrijs = nieuwItem.getPrijs();
            System.out.println("De prijs van dit item is: " + currencyFormatter.format(nieuwItemPrijs));

            System.out.println("Wilt u nog wat bestellen? (y/n)");
            String nieuwItemInBestellingKeuze = scanner.nextLine();
            isNieuweBestelling = nieuwItemInBestellingKeuze.equals("y"); // Als gebruiker "y" antwoord → plaats nieuw product in bestelling
        }
    }

    private static void printKassaBon() {
        double totaalPrijsBestelling = berekenTotaalPrijs();

        System.out.println("--------------------Bestelling--------------------");
        for (Product item : bestelling) {
            printProduct(item);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + currencyFormatter.format(totaalPrijsBestelling));
    }

    private static double berekenTotaalPrijs() {
        double totaalPrijsBestelling = 0.0;
        for (Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
        }
        return totaalPrijsBestelling;
    }

    private static Bezorging vindBezorging() {
        for (Product item : bestelling) {
            if (item instanceof Bezorging) {
                return (Bezorging) item;
            }
        }
        return null;
    }

    private static void startBezorgAnimatie(double minutenOnderweg) {
        bezorger.startBezorgAnimatie(minutenOnderweg);
    }

    private static void toonMenu() {
        System.out.println("----------------- Menu -----------------");
        System.out.println("Broodje doner | Durum doner             ");
        System.out.println("Cola          | Fanta       | Ranja     ");
        System.out.println("----------------------------------------");
    }

    private static void printProduct(Product item) {
        if (item instanceof DonerProduct donerProduct) {
            String sausToevoeging = "| Saus: " + donerProduct.getSausNaam();
            System.out.println("Naam: " + item.getNaam() + " " + sausToevoeging + " | prijs: " + currencyFormatter.format(item.getPrijs()));
        } else {
            System.out.println("Naam: " + item.getNaam() + " | prijs: " + currencyFormatter.format(item.getPrijs()));
        }
    }
}
