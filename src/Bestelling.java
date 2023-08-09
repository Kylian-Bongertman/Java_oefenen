public class Bestelling {
    String grootte;
    Double price;


    public Bestelling(String grootte) {
        this.grootte = grootte;
        this.price = getPrice();
    }

    public Double getPrice() {
        return -1.0;
    }
}

