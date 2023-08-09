public class Durum_doner extends Bestelling {
    Durum_doner(String grootte) {
        super(grootte);
    }

    @Override
    public Double getPrice() {
        if (grootte.equals("Normaal")) {
            return 4.5;
        } else if (grootte.equals("Mega")) {
            return 7.0;
        } else {
            return -1.0;
        }
    }
}
