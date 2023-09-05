package schonewinkel;

import schonewinkel.Bezorgingen.BezorgDienst;
import schonewinkel.Bezorgingen.Bezorging;

import java.util.ArrayList;
import java.util.Scanner;

public class KassaMedewerker {
    public Product vraagTeBestellenProduct(Scanner scanner) {
        String besteldProduct = scanner.nextLine();
        String[] frisdrankNamen = FrisdrankMenu.getFrisdrankNamen();
        Double[] frisdrankPrijzen = FrisdrankMenu.getFrisdrankPrijzen();
        boolean gekozenGrootte;
        Saus gekozenSaus;

        for (int i = 0; i < frisdrankNamen.length; i++) {
            if (besteldProduct.equals(frisdrankNamen[i])) {
                return new Product(frisdrankNamen[i], frisdrankPrijzen[i]);
            }
        }

        switch (besteldProduct) {
            case "Broodje doner" -> {
                gekozenGrootte = vraagDonerGrootteKeuze();
                gekozenSaus = vraagSausKeuze();
                return new BroodjeDoner(gekozenGrootte, gekozenSaus);
            }
            case "Durum doner" -> {
                gekozenGrootte = vraagDonerGrootteKeuze();
                gekozenSaus = vraagSausKeuze();
                return new DurumDoner(gekozenGrootte, gekozenSaus);
            }
            default -> {
                System.out.println("Dit staat niet op het menu!");
                return vraagTeBestellenProduct(scanner);
            }
        }
    }

    public boolean vraagDonerGrootteKeuze() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies de grootte: (Normaal/Mega)");
        String gekozenGrootte = scanner.nextLine();
        if (gekozenGrootte.equals("Mega")) {
            return true;
        } else if (gekozenGrootte.equals("Normaal")) {
            return false;
        } else {
            System.out.println("Deze grootte bestaat niet!");
            return vraagDonerGrootteKeuze();
        }
    }

    public Saus vraagSausKeuze() {
        Scanner scanner = new Scanner(System.in);
        String naamGekozenSaus;
        Saus gekozenSaus;
        SausMenu[] beschikbareSaus = SausMenu.values();

        System.out.println("Kies de saus: ");
        System.out.println(SausMenu.getSausMenu());

        naamGekozenSaus = scanner.nextLine();

        for (SausMenu saus : beschikbareSaus) {
            if (naamGekozenSaus.equals(saus.getNaam())) {
                gekozenSaus = new Saus(saus.getNaam(), saus.getPrijs());
                return gekozenSaus;
            }
        }
        System.out.println("Deze saus bestaat niet!");
        return vraagSausKeuze(); //Roep de methode opnieuw aan als de saus niet geldig is.
    }

    public Bezorging vraagVerzendMethode(Scanner scanner, ArrayList<Product> bestelling) {
        System.out.println("Wil je je bestelling thuis bezorgd hebben? (y/n)");
        String bestellingBezorgenKeuze = scanner.nextLine();

        boolean isAkkoordMetBezorging;
        if (bestellingBezorgenKeuze.equals("y")) {
            double bezorgTijd = BezorgDienst.berekenBezorgTijd();
            double bezorgPrijs = BezorgDienst.berekenBezorgPrijs(bestelling);
            String bezorgMethode = BezorgDienst.vindBezorgMethodeNaam(bestelling);
            System.out.println("De bezorgTijd is: " + bezorgTijd + " minuten. " + " De bezorgPrijs is: " + bezorgPrijs + " De bestelling wordt verzonden in een " + bezorgMethode); //De verzendMethode is: .. Brief/ doos
            System.out.println("Is dit akkoord? (y/n)");
            String bezorgingAkkoordKeuze = scanner.nextLine();
            isAkkoordMetBezorging = bezorgingAkkoordKeuze.equals("y");

            if (isAkkoordMetBezorging) {
                return new Bezorging(bezorgTijd, bezorgPrijs, bezorgMethode);
            }
        }
        return null;
    }

    public int vraagKortingCode(Scanner scanner) {
        while (true) {
            System.out.println("Heeft u een korting code?");
            String heeftKortingCode = scanner.nextLine();
            if (heeftKortingCode.equals("y")) {
                System.out.println("Geef uw korting code op:");
                String opgegevenKortingCode = scanner.nextLine();

                KortingCodeOpties[] kortingCodes = KortingCodeOpties.values();
                for (KortingCodeOpties kortingCode : kortingCodes) {
                    if (opgegevenKortingCode.equals(kortingCode.getNaam())) {
                        return kortingCode.getKortingPercentage();
                    }
                }
                System.out.println("Korting code niet gevonden.");
            } else {
                return 0;
            }
        }
    }
}


