package schonewinkel;

import java.util.Scanner;

public class KassaMedewerker {

    public static Product neemBestellingAan() {
        Scanner scanner = new Scanner(System.in);
        String besteldProduct = scanner.nextLine();

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

    public static boolean getDonerGrootte() {
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

    public static String getSaus() {
        Scanner scanner = new Scanner(System.in);
        String gekozenSaus = "";
        String[] beschikbareSaus = Saus.getBeschikbareSaus();

        System.out.println("Kies de saus: ");
        for (int i = 0; i < beschikbareSaus.length; i++) {
            System.out.print(beschikbareSaus[i] + ", ");
        }
        gekozenSaus = scanner.nextLine();

        for (int i = 0; i < beschikbareSaus.length; i++) {
            if (gekozenSaus.equals(beschikbareSaus[i])) {
                return gekozenSaus;
            }
        }
        System.out.println("Deze saus bestaat niet!");
        return getSaus();
    }
}
