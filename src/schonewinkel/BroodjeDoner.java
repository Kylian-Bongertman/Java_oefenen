package schonewinkel;

public class BroodjeDoner extends DonerProduct {
    BroodjeDoner() {
        if (isExtraGroot) {
            naam = "Broodje doner mega";
            prijs = 8.0;
        } else {
            naam = "Broodje doner";
            prijs = 5.0;
        }
        addSaus();

    }
}

