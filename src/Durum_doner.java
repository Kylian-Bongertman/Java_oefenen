public class Durum_doner extends Bestelling implements Ingredient {
    Durum_doner(String grootte) {
        super(grootte);
    }

    @Override
    public Double getPrijs() {
        if (grootte.equals("Normaal")) {
            return 4.5;
        } else if (grootte.equals("Mega")) {
            return 7.0;
        } else {
            return -1.0;
        }
    }
}
