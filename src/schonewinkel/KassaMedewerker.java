package schonewinkel;

import java.util.Scanner;

public class KassaMedewerker {
    public Product neemBestellingAan() {
        Scanner scanner = new Scanner(System.in);
        String besteldProduct = scanner.nextLine();
        String[] frisdrankNamen = FrisdrankMenu.getFrisdrankNamen();
        Double[] frisdrankPrijzen = FrisdrankMenu.getFrisdrankPrijzen();
        boolean gekozenGrootte;
        Saus gekozenSaus;

        for (int i = 0; i < frisdrankNamen.length; i++) {
            if (besteldProduct.equals(frisdrankNamen[i])) {
                Product frisdrank = new Product(frisdrankNamen[i], frisdrankPrijzen[i]);
                return frisdrank;
            }
        }

        switch (besteldProduct) {
            case "Broodje doner" :
                gekozenGrootte = getDonerGrootte();
                gekozenSaus = getSaus();
                BroodjeDoner broodje = new BroodjeDoner(gekozenGrootte, gekozenSaus);
                return broodje;
            case "Durum doner" :
                gekozenGrootte = getDonerGrootte();
                gekozenSaus = getSaus();
                DurumDoner durum = new DurumDoner(gekozenGrootte, gekozenSaus);
                return durum;
            default:
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
                gekozenSaus = new Saus(saus.getNaam(), saus.getPrijs());
                return gekozenSaus;
            }
        }
        System.out.println("Deze saus bestaat niet!");
        return getSaus(); //Roep de methode opnieuw aan als de saus niet geldig is.
    }
}


