package schonewinkel.Bezorgingen;

import schonewinkel.Product;

import java.util.ArrayList;

public class BezorgDienst {
    private double bezorgTijd;
    private double bezorgPrijs;


    public static double berekenBezorgTijd() { //BezorgTijd in minuten.
        double bezorgTijd;
        bezorgTijd = Math.random() * 100;
        bezorgTijd = Math.round(bezorgTijd);
        return bezorgTijd;
    }

    public static double berekenBezorgPrijs(ArrayList<Product> bestelling) {
        double bezorgPrijs = 0.0;
        Bezorging bezorging = selecteerJuisteDoos(bestelling);

        bezorgPrijs += bezorging.getPrijs();
        return bezorgPrijs;
    }

    public static double berekenBenodigdeCapaciteit(ArrayList<Product> bestelling) {
        double benodigdeCapaciteit = 0.0;
        for (Product Item : bestelling) {
            benodigdeCapaciteit += Item.getVolume();
        }
        return benodigdeCapaciteit;
    }

    public static Bezorging selecteerJuisteDoos(ArrayList<Product> bestelling) {
        double benodigdeCapacteit = berekenBenodigdeCapaciteit(bestelling);
        for (BezorgOpties optie : BezorgOpties.values()) {
            if (optie.getCapaciteit() >= benodigdeCapacteit) {
                Bezorging bezorging = new Bezorging(berekenBezorgTijd(), optie.getPrijs());
                return bezorging;
            }
        }
        return null; //crasht als benodigde capaciteit meer is dan 10.
    }

//    public void maakBezorgingAan(ArrayList<Product> bestelling) {
//        Bezorging bezorging = selecteerJuisteDoos(bestelling);
//        System.out.print("Doos: " + bezorging.getNaam());
//    }

}



