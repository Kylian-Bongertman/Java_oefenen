package schonewinkel;

import java.util.Scanner;

public class KassaMedewerker {
    String[] productNamen = FrisdrankMenu.getFrisdrankNamen();
    Double[] productPrijzen = FrisdrankMenu.getFrisdrankPrijzen();

    public Product neemBestellingAan() {
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
            boolean gekozenGrootte = getDonerGrootte();
            Saus gekozenSaus = getSaus();

            BroodjeDoner broodje = new BroodjeDoner(gekozenGrootte, gekozenSaus);
            return broodje;
        } else if (besteldProduct.equals("Durum doner")) {
            boolean gekozenGrootte = getDonerGrootte();
            Saus gekozenSaus = getSaus();

            DurumDoner durum = new DurumDoner(gekozenGrootte, gekozenSaus);
            return durum;
        } else {
            System.out.println("Dit staat niet op het menu!");
            return neemBestellingAan();
        }
    }

    public boolean getDonerGrootte() {
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

    public Saus getSaus() {
        Scanner scanner = new Scanner(System.in);
        String naamGekozenSaus = "";
        Saus gekozenSaus = null;
        SausMenu[] beschikbareSaus = SausMenu.values();

        System.out.println("Kies de saus: ");
        System.out.println(SausMenu.getSausMenu());

        naamGekozenSaus = scanner.nextLine();

        for (SausMenu saus : beschikbareSaus) {
            if (naamGekozenSaus.equals(saus.getNaam())) {
                gekozenSaus = new Saus();
                gekozenSaus.setNaamSaus(saus.getNaam());
                gekozenSaus.setPrijsSaus(saus.getPrijs());
                return gekozenSaus;
            }
        }
        System.out.println("Deze saus bestaat niet!");
        return getSaus();
    }
}


