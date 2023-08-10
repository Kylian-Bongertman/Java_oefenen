public class Broodje_doner extends Bestelling implements Ingredient {
    private Saus saus = null;

    Broodje_doner(String grootte) {
        super(grootte);
    }

    @Override
    public Double getPrijs() {
        if (grootte.equals("Normaal")) {
            return 5.0;
        } else if (grootte.equals("Mega")) {
            return 8.0;
        } else {
            return -1.0;
        }
    }
    public Saus getSaus() {
        return saus;
    }
    public void setSauce(Saus saus) {
        this.saus = saus;
    }
}

//Feature requests:
//Doner donderdag 1 euro korting