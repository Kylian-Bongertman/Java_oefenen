package schonewinkel;

import java.util.Scanner;

public class KassaMedewerker {
    String[] productNamen = FrisdrankMenu.getFrisdrankNamen();
    Double[] productPrijzen = FrisdrankMenu.getFrisdrankPrijzen();

    public static Product neemBestellingAan() {
        Scanner scanner = new Scanner(System.in);
        String besteldProduct = scanner.nextLine();
        String[] frisdrankNamen = FrisdrankMenu.getFrisdrankNamen();
        Double[] frisdrankPrijzen = FrisdrankMenu.getFrisdrankPrijzen();


        for (int i = 0; i < frisdrankNamen.length; i++) {
            if (besteldProduct.equals(frisdrankNamen[i])) {
                Product frisdrank = new Product();
                frisdrank.setNaam(frisdrankNamen[i]);
                frisdrank.setPrijs(frisdrankPrijzen[i]);
                return frisdrank;
            }
        }
        if (besteldProduct.equals("Broodje doner")) {
            BroodjeDoner broodje = new BroodjeDoner();
            return broodje;
        } else if (besteldProduct.equals("Durum doner")) {
            DurumDoner durum = new DurumDoner();
            return durum;
        } else {
                System.out.println("Dit staat niet op het menu!");
                return neemBestellingAan();
            }
        }

        public static boolean getDonerGrootte () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kies de grootte: (Normaal/Mega)");
            String gekozenGrootte = scanner.nextLine();
            if (gekozenGrootte.equals("Mega")) {
                return true;
            } else if (gekozenGrootte.equals("Normaal")) {
                return false;
            } else {
                System.out.println("Deze grootte bestaat niet!");
                return getDonerGrootte();
            }
        }

        public static Saus getSaus () {
            Scanner scanner = new Scanner(System.in);
            String naamGekozenSaus = "";
            Saus gekozenSaus = new Saus();
            String[] beschikbareSaus = SausMenu.getSausNamen();
            Double[] prijsSaus = SausMenu.getSausPrijzen();

            System.out.println("Kies de saus: ");
            for (int i = 0; i < beschikbareSaus.length; i++) {
                System.out.print(beschikbareSaus[i] + ": $" + prijsSaus[i] + ", ");
            }
            System.out.println();
            naamGekozenSaus = scanner.nextLine();

            for (int i = 0; i < beschikbareSaus.length; i++) {
                if (naamGekozenSaus.equals(beschikbareSaus[i])) {
                    gekozenSaus.setNaamSaus(beschikbareSaus[i]);
                    gekozenSaus.setPrijsSaus(prijsSaus[i]);
                    return gekozenSaus;
                }
            }
            System.out.println("Deze saus bestaat niet!");
            return getSaus();
        }

//        public void addDonerSaus (DonerProduct donerProduct) {
//                donerProduct.prijs += donerProduct.saus.getPrijsSaus();
//                donerProduct.naam += " | Saus: " + donerProduct.saus.getNaamSaus();
//            }
        }


