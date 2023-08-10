public class Bestelling {
    String grootte;
    Double price;


    public Bestelling(String grootte) {
        this.grootte = grootte;
        this.price = getPrijs();
    }

    public Double getPrijs() {
        return -1.0;
    }
}

