package schonewinkel;

public enum KortingCodeOpties {
    TIEN_PROCENT("TIEN_PROCENT", 10),
    TWINTIG_PROCENT("TWINTIG_PROCENT", 20),
    DERTIG_PROCENT("DERTIG_PROCENT",30),
    VEERTIG_PROCENT("VEERTIG_PROCENT",40),
    VIJFTIG_PROCENT("VIJFTIG_PROCENT", 50),
    ZESTIG_PROCENT("ZESTIG_PROCENT", 60),
    ZEVENTIG_PROCENT("ZEVENTIG_PROCENT", 70),
    TACHTIG_PROCENT("TACHTIG_PROCENT", 80);

    private final int kortingPercentage;
    private final String naam;

    KortingCodeOpties(String naam, int kortingPercentage) {
        this.kortingPercentage = kortingPercentage;
        this.naam = naam;
    }

    public int getKortingPercentage() {
        return kortingPercentage;
    }

    public String getNaam() {
      return naam;
    }
}
