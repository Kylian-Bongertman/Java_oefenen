import java.util.Scanner;

public class Store {
    public Store() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner ");
        System.out.println("--------------------------");
    }

    public Bestelling takeOrder(String product, Scanner scanner) {
        if (product.equals("Broodje doner")) {
            Broodje_doner bestelling = new Broodje_doner();

            System.out.println("Kies de grootte van de bestelling (Normaal/Mega):");
            String gekozenGrootteString = scanner.nextLine();
            ProductGrootte grootte = ProductGrootte.valueOf(gekozenGrootteString.toUpperCase());
            bestelling.setProductGrootte(grootte);

            System.out.println("Kies de saus die je wilt toevoegen: " + Saus.getNamen());
            String gekozenSausString = scanner.nextLine();
            bestelling.setSaus(Saus.valueOf(gekozenSausString.toUpperCase()));

            System.out.println("De gekozen saus is: " + ((Broodje_doner) bestelling).getSaus());

            System.out.println("Welke salade wil je? " + Salade.getNamen());
            for(int i=0; i< 3; i++) {
                String gekozenSaladeString = scanner.nextLine();
                bestelling.addSalade(Salade.valueOf(gekozenSaladeString.toUpperCase()));
            }
            System.out.println(bestelling.getSalades());

            return bestelling;
        }
        else if(product.equals("Durum doner")) {
            return new Durum_doner();
        }else {
            // Voeg hier andere mogelijke producten toe
            return  new Bestelling();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store donerIX = new Store();

        System.out.println("Kies het product (Broodje doner/Durum doner):");
        String product = scanner.nextLine();

        //System.out.println("Kies de grootte van de bestelling (Normaal/Mega):");
        //String besteldeGrootte = scanner.nextLine();

        Bestelling kylianbestelling = donerIX.takeOrder(product, scanner);
        System.out.println("Bedankt voor je bestelling, dat wordt dan " + kylianbestelling.getPrijs() + " Euro");

        scanner.close();
    }
}
