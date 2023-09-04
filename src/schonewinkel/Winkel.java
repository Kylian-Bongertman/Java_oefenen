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
        checkKortingsCode();
        kiesVerzendMethode();
        printKassaBon(bestelling);
        stuurBezorger();
    }

    private static void stuurBezorger() throws Exception {
        Bezorging bezorging = vindBezorging(bestelling);

        if (bezorging != null) {
            System.out.println("De bezorging zal plaatsvinden over: " + bezorging.getBezorgTijd() + " minuten");
            startBezorgAnimatie(bezorging.getBezorgTijd());
        }
    }

    private static void checkKortingsCode() {
        while (true) {
            System.out.println("Heeft u een korting code?");
            String heeftKortingCode = scanner.nextLine();
            if (heeftKortingCode.equals("y")) {
                System.out.println("Geef uw korting code op:");
                String opgegevenKortingCode = scanner.nextLine();

                KortingCodeOpties[] kortingCodes = KortingCodeOpties.values();
                for (KortingCodeOpties kortingCode : kortingCodes) {
                    if (opgegevenKortingCode.equals(kortingCode.getNaam())) {
                        geefKorting(kortingCode);
                        System.out.println("De korting is toegepast.");
                        return; // Methode wordt afgebroken als korting code gevonden is.
                    }
                }
                System.out.println("Korting code niet gevonden.");
            } else {
                return; // Als de gebruiker "n" invoert, verlaten we de methode zonder verder te vragen.
            }
        }
    }

    private static void geefKorting(KortingCodeOpties kortingCode) {
        double percentageVanOrigineelPrijs;
        percentageVanOrigineelPrijs = (100 - kortingCode.getKortingPercentage());
        for (Product item : bestelling) {
            double nieuwPrijs = item.getPrijs() * (percentageVanOrigineelPrijs / 100);
            item.setPrijs(nieuwPrijs);
        }
    }

    private static void kiesVerzendMethode() {
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

    private static void printKassaBon(List<Product> bestelling) {
        double totaalPrijsBestelling = berekenTotaalPrijs(bestelling);

        System.out.println("--------------------Bestelling--------------------");
        for (Product item : bestelling) {
            printProduct(item);
        }
        System.out.println("--------------------------------------------------");
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

    private static void startBezorgAnimatie(double minutenOnderweg) throws Exception {
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
