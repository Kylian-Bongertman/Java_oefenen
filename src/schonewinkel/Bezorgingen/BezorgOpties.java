package schonewinkel.Bezorgingen;

public enum BezorgOpties {
    BRIEVENPOST("Brief", 0.5, 1.0),
    KLEINE_DOOS("kleine doos", 3.0, 3.0),
    MIDDEL_DOOS("Middel doos", 5.0, 5.0),
    GROTE_DOOS("Grote doos", 7.0, 10.0);

    private String naam;
    private double prijs;
    private double capaciteit;

    BezorgOpties(String naam, double prijs, double capaciteit) {
        this.naam = naam;
        this.prijs = prijs;
        this.capaciteit = capaciteit;
    }
}

