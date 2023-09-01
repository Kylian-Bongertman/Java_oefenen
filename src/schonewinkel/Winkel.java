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
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> bestelling = new ArrayList<>();
    static KassaMedewerker Tycho = new KassaMedewerker();
    static Bezorger Pietje = new Bezorger();
    static Locale locale = new Locale("en", "NL"); //Om Euro te selecteren als geldeenheid.
    static NumberFormat formatter = NumberFormat.getCurrencyInstance(locale); // Om prijs in Euro weer te geven.

    public static void main(String[] args) throws Exception {
        //Bezorger.startBezorgAnimatie();
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
            Product nieuwItem = Tycho.voegProductToeAanBestelling();
            bestelling.add(nieuwItem);
            double nieuwItemPrijs = nieuwItem.getPrijs();
            System.out.println("De prijs van dit item is: " + formatter.format(nieuwItemPrijs));

            System.out.println("Wilt u nog wat bestellen? (y/n)");
            String nieuwItemInBestellingKeuze = scanner.nextLine();
            isNieuweBestelling = nieuwItemInBestellingKeuze.equals("y"); // Als gebruiker "y" antwoord → plaats nieuw product in bestelling
        }
    }

    private static void printKassaBon(List<Product> bestelling) throws Exception {
        Double totaalPrijsBestelling = 0.0;
        boolean heeftBezorging = false;
        Bezorging bezorging = null;

        System.out.println("--------------------Bestelling--------------------");
        for (Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
            if (item instanceof DonerProduct) {
                DonerProduct donerProduct = (DonerProduct) item;
                String sausToevoeging = "| Saus: " + donerProduct.getSausNaam();
                System.out.println("Naam: " + item.getNaam() + " " + sausToevoeging + " | prijs: " + item.getPrijs());
            } else {
                System.out.println("Naam: " + item.getNaam() + " | prijs: " + formatter.format(item.getPrijs())); //formatter om tweede decimaal weer te geven voor prijs.
            }

            if (item instanceof Bezorging) {
                heeftBezorging = true;
                bezorging = (Bezorging) item; // Als bezorging gevonden wordt, wijs dit dan toe aan bezorging variabele
            }
        }
        System.out.println("--------------------------------------------------");
        if (heeftBezorging) {
            System.out.println("De bezorging zal plaatsvinden over: " + bezorging.getBezorgTijd() + " minuten");
            double minutenOnderweg = bezorging.getBezorgTijd();
            stuurBezorger(minutenOnderweg);
        }
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + formatter.format(totaalPrijsBestelling)); //Som van bestelling
    }

    private static void stuurBezorger(double minutenOnderweg) throws Exception {
        Pietje.startBezorgAnimatie(minutenOnderweg);
    }

    public static void toonMenu() {
        System.out.println("----------------- Menu -----------------");
        System.out.println("Broodje doner | Durum doner             ");
        System.out.println("Cola          | Fanta       | Ranja     ");
        System.out.println("----------------------------------------");
    }
}

