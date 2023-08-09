public class Bestelling {
    Double price;
    String grootte;

    public Bestelling(String grootte) {
        this.grootte = grootte;
        this.price = getPrice();
    }

    public Double getPrice() {
        return 0.111;
    }
}

