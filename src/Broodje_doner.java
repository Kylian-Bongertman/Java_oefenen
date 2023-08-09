public class Broodje_doner extends Bestelling {
    private String sauce;
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
    public String getSauce() {
        return "We hebben knoflooksaus, yoghurtsaus, pittige saus en tahini.";
    }
    public void setSauce(String chosenSauce) {
        this.sauce = chosenSauce;
    }
}
