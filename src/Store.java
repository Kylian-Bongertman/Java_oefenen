public class Store {
    static String name;
    public Store(String customerName) {
        name = customerName;
        System.out.println("Welkom bij DonerIX!");
    }

    public void order(Bestelling bestelling) {

    }

    public static void main(String[] args) {
        System.out.println("Start of the main method.");
        Store donerIX = new Store("Kylian");

        Bestelling kylianbestelling = new Broodje_doner("Mega");
        System.out.println("Bedankt voor je bestelling " + name + ", dat wordt dan " + kylianbestelling.price + " Euro");
    }




}
