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
            String availableSauce = ((Broodje_doner) bestelling).getSauce();
            System.out.println("Welke saus wil je? Beschikbare sauzen: " + availableSauce);
            String chosenSauce = scanner.nextLine();
            ((Broodje_doner) bestelling).setSauce(chosenSauce);
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
        System.out.println("Bedankt voor je bestelling, dat wordt dan " + kylianbestelling.price + " Euro");

        scanner.close();
    }




}
