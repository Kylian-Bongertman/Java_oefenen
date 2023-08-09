public class Broodje_doner extends Bestelling {
    Broodje_doner(String grootte) {
        super(grootte);
    }

    @Override
    public Double getPrice() {
        if (grootte.equals("Normaal")) {
            return 5.0;
        } else if (grootte.equals("Mega")) {
            return 8.0;
        } else {
            return -1.0;
        }
    }
}
