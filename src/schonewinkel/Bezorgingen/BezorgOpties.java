package schonewinkel.Bezorgingen;

public enum BezorgOpties {
    BRIEVENPOST("Brief", 0.5, 1.0),
    KLEINE_DOOS("kleine doos", 3.0, 3.0),
    MIDDEL_DOOS("Middel doos", 5.0, 5.0),
    GROTE_DOOS("Grote doos", 7.0, 10.0);

    private final String naam;
    private final double prijs;
    private final double capaciteit;

    BezorgOpties(String naam, double prijs, double capaciteit) {
        this.naam = naam;
        this.prijs = prijs;
        this.capaciteit = capaciteit;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public double getCapaciteit() {
        return capaciteit;
    }
}

