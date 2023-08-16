import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class Store {
    public Store() {
    }

    public Product takeOrder(String productKeuze) {
        if(productKeuze.equals("BROODJE_DONER_")) {
            DonerProduct bestelling = new DonerProduct(productKeuze);
            return bestelling;
        }
        else if(productKeuze.equals("DURUM_DONER_")) {
            DonerProduct bestelling = new DonerProduct(productKeuze);
            return bestelling;
        }
        else if(productKeuze.equals("COLA_")) {
            Drinken bestelling = new Drinken(productKeuze);
            return bestelling;
        }

        return null;
    }
    protected String getProductKeuze() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kies het product:");
        String productKeuze = scanner.nextLine().toUpperCase();
        if(productKeuze.equals("BROODJE DONER")) { productKeuze = "BROODJE_DONER_"; }
        else if (productKeuze.equals("DURUM DONER")) { productKeuze = "DURUM_DONER_"; }
        else if (productKeuze.equals("COLA")) { productKeuze = "COLA_"; }
        return productKeuze;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isNieuweBestellingMaken = true;
        boolean isDonerDonderdag = false;
        List<Product> bestelling = new ArrayList<>(); // Lijst voor bestelling

        Store donerIX = new Store();
        isDonerDonderdag = checkDonerDonderdag(); // Op donderdag 10% korting op Doner producten
        if(isDonerDonderdag) {
            donerIX.setDonerKortingPercentage(10);
        }

        while (isNieuweBestellingMaken) {
            toonMenu();
            String productKeuze = donerIX.getProductKeuze();
            Product nieuwItem = donerIX.takeOrder(productKeuze);

            System.out.println("Bedankt voor je bestelling, de prijs van dit item is: " + nieuwItem.getPrijs() + " Euro");
            bestelling.add(nieuwItem);
            System.out.println("Wil u nog wat bestellen? (y/n)");
            String nieuweBestellingKeuze = scanner.nextLine();
            if (nieuweBestellingKeuze.equals("y")) {
                isNieuweBestellingMaken = true;
            } else {
                isNieuweBestellingMaken = false;
            }
        }
        printKassaBon(bestelling);
    }

    private void setDonerKortingPercentage(double percentage) {
        ProductGrootte.setKorting(percentage);
    }

    private static boolean checkDonerDonderdag() {
        boolean isDonerDonderdag = false;
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        String dayOfWeekString = currentDayOfWeek.getDisplayName(TextStyle.FULL, new Locale("nl", "NL")); // Stijlvolle weergave van de huidige dag van de week (bijv. "Maandag", "Dinsdag", enz.)

        System.out.println("Huidige dag van de week: " + dayOfWeekString);
        if(dayOfWeekString.equals("woensdag")) {
            isDonerDonderdag = true;
            System.out.println("Het is Doner donderdag, Dit betekend: 10% korting op alle Doner producten!");
        }
        return isDonerDonderdag;
    }

    private static void printKassaBon(List<Product> bestelling) {
        Double totaalPrijsBestelling = 0.0;

        System.out.println("--------------------Bestelling--------------------");
        for(Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
            System.out.println("Naam: " + item.productGrootte.getNaam() + " | prijs: " + item.getPrijs());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + totaalPrijsBestelling + " Euro"); //Som van bestelling
    }

    private static void toonMenu() {
        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner");
        System.out.println("Cola          |            ");
        System.out.println("--------------------------");
    }
}
