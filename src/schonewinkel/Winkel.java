package schonewinkel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Winkel {

    public static void main(String[] args) {
        List<Product> bestelling = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isNieuweBestelling = true;

        System.out.println("Welkom bij DonerIX!");
        System.out.println("Mag ik uw bestelling?");

            while(isNieuweBestelling) {
                toonMenu();
                Product nieuwItem = neemBestellingAan();
                bestelling.add(nieuwItem);
                Double nieuwItemPrijs = nieuwItem.getPrijs();
                System.out.println("De prijs van dit item is: " + nieuwItemPrijs);

                System.out.println("Wilt u nog wat bestellen? (y/n)");
                String nieuweBestellingKeuze = scanner.nextLine();
                isNieuweBestelling = nieuweBestellingKeuze.equals("y"); // Als gebruiker "y" antwoord → plaats nieuwe bestelling
            }
            printKassaBon(bestelling);
        // Geef prijs weer
    }

    private static void printKassaBon(List<Product> bestelling) {
        Double totaalPrijsBestelling = 0.0;

        System.out.println("--------------------Bestelling--------------------");
        for(Product item : bestelling) {
            totaalPrijsBestelling += item.getPrijs();
            System.out.println("Naam: " + item.getNaam() + " | prijs: " + item.getPrijs());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Bedankt voor je bestelling, dat wordt dan: " + totaalPrijsBestelling + " Euro"); //Som van bestelling
    }

    public static void toonMenu() {
        System.out.println("---------- Menu ----------");
        System.out.println("Broodje doner | Durum doner");
        System.out.println("Cola          |            ");
        System.out.println("--------------------------");
        // Laat menu zien
    }
    public static Product neemBestellingAan() {
        Scanner scanner = new Scanner(System.in);
        boolean isNieuweBestelling = true;
        String besteldProduct = scanner.nextLine();

        //while(isNieuweBestelling == true) {
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
            //return neemBestellingAan();

            // Vraag gebruiker input
            // Staat dit op het menu?
            // Maak Product aan wat gebruiker vraagt

    }

//getprijs maken voor broodje
//lijst maken
//totaalprijs berekenen
//getprijs maken voor durum
//if broodje / else if durum


