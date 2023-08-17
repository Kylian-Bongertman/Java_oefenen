package schonewinkel;

public class Winkel {

    public static void main(String[] args) {
        toonMenu();
        Product nieuwItem = neemBestellingAan();
        Double nieuwItemPrijs = nieuwItem.getPrijs();
        System.out.println("De prijs van dit item is: " + nieuwItemPrijs);

        // Geef prijs weer
    }

    public static void toonMenu() {
        // Laat menu zien
    }
    public static Product neemBestellingAan() {
        String besteldProduct = "Broodje doner";
        BroodjeDoner broodje = new BroodjeDoner();
        return broodje;

        // Vraag gebruiker input
        // Staat dit op het menu?
        // Maak Product aan wat gebruiker vraagt
    }
}
//getprijs maken voor broodje
//lijst maken
//totaalprijs berekenen
//getprijs maken voor durum
//if broodje / else if durum


