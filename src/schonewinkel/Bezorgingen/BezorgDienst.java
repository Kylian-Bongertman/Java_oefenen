package schonewinkel.Bezorgingen;

import schonewinkel.Product;

import java.util.ArrayList;

public class BezorgDienst {

    public static double berekenBezorgTijd() { //BezorgTijd in minuten.
        double bezorgTijd;
        bezorgTijd = Math.random() * 100;
        bezorgTijd = Math.round(bezorgTijd);
        return bezorgTijd;
    }

    public static double berekenBezorgPrijs(ArrayList<Product> bestelling) {
        double bezorgPrijs = 0.0;
        Bezorging bezorging = selecteerJuisteDoos(bestelling);

        if (bezorging != null) {
            bezorgPrijs += bezorging.getPrijs();
        } else {
            System.out.println("Geen geschikte bezorgoptie gevonden voor deze bestelling.");
        }
        return bezorgPrijs;
    }

    public static String vindBezorgMethodeNaam(ArrayList<Product> bestelling) {
        String bezorgMethode = "";
        Bezorging bezorging = selecteerJuisteDoos(bestelling);

        if (bezorging != null) {
            bezorgMethode = bezorging.getBezorgMethode();
        } else {
            System.out.println("Geen geschikte bezorgoptie gevonden voor deze bestelling.");
        }
        return bezorgMethode;
    }

    public static double berekenBenodigdeCapaciteit(ArrayList<Product> bestelling) {
        double benodigdeCapaciteit = 0.0;
        for (Product Item : bestelling) {
            benodigdeCapaciteit += Item.getVolume();
        }
        return benodigdeCapaciteit;
    }

    public static Bezorging selecteerJuisteDoos(ArrayList<Product> bestelling) {
        double benodigdeCapaciteit = berekenBenodigdeCapaciteit(bestelling);
        for (BezorgOpties optie : BezorgOpties.values()) {
            if (optie.getCapaciteit() >= benodigdeCapaciteit) {
                return new Bezorging(berekenBezorgTijd(), optie.getPrijs(), optie.getNaam());
            }
        }
        return null; //crasht als benodigde capaciteit meer is dan 10.
    }
}



