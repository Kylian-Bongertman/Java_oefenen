package schonewinkel.Bezorgingen;

public class Doos {
    private String naam;
    private double prijs;
    private double capaciteit;

    Doos(String naam, double prijs, double capaciteit) {
        this.naam = naam;
        this.prijs = prijs;
        this.capaciteit = capaciteit;
    }

    public double getCapaciteit() {
        return capaciteit;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }
}
