import java.util.Scanner;

public class Store {
    public Store() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner ");
        System.out.println("--------------------------");
    }

    public DonerProduct takeOrder(String product, Scanner scanner) {
        DonerProduct bestelling = null;
        if (product.equals("Broodje doner")) {
            bestelling = new DonerProduct("BROODJE_DONER_");
            return bestelling;

        } else if (product.equals("Durum doner")) {
            bestelling = new DonerProduct("DURUM_DONER_");
                return bestelling;
        }

        // Voeg hier andere mogelijke producten toe
        return new DonerProduct("");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store donerIX = new Store();

        System.out.println("Kies het product (Broodje doner/Durum doner):");
        String product = scanner.nextLine();

        DonerProduct kylianbestelling = donerIX.takeOrder(product, scanner);
        System.out.println("Bedankt voor je bestelling, dat wordt dan " + kylianbestelling.getPrijs() + " Euro");

        scanner.close();
    }
}
