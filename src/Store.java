import java.util.Scanner;

public class Store {
    public Store() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ---------- ");
        System.out.println("Broodje doner | Durum doner ");
        System.out.println("--------------------------");
    }

    public Bestelling takeOrder(String product, String grootte, Scanner scanner) {
        Bestelling bestelling;

        if (product.equals("Broodje doner")) {
            bestelling = new Broodje_doner(grootte);
            System.out.println("Kies de saus die je wilt toevoegen: " + Saus.getNamen());
            String chosenSauceString = scanner.nextLine();
            ((Broodje_doner) bestelling).setSauce(Saus.valueOf(chosenSauceString.toUpperCase()));
            System.out.println("De gekozen saus is: " + ((Broodje_doner) bestelling).getSaus());
        }
        else if(product.equals("Durum doner")) {
            bestelling = new Durum_doner(grootte);
        }else {
            // Voeg hier andere mogelijke producten toe
            bestelling = new Bestelling(grootte);
        }
        return bestelling;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store donerIX = new Store();

        System.out.println("Kies het product (Broodje doner/Durum doner):");
        String product = scanner.nextLine();

        System.out.println("Kies de grootte van de bestelling (Normaal/Mega):");
        String besteldeGrootte = scanner.nextLine();

        Bestelling kylianbestelling = donerIX.takeOrder(product, besteldeGrootte, scanner);
        System.out.println("Bedankt voor je bestelling, dat wordt dan " + kylianbestelling.getPrijs() + " Euro");

        scanner.close();
    }
}
