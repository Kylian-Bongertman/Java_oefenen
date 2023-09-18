package kebabzaak;

public class Product {
    protected String naam = "Product";
    protected double prijs = 0.0;
    protected double volume = 1.0;

    public Product(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }
    public Product() {
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return this.prijs;
    }

    public double getVolume() {
        return volume;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
