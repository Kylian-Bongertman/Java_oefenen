package schonewinkel;

public enum SausMenu {
    KNOFLOOKSAUS("Knoflook saus", 0.30),
    SAMBAL("Sambal", 0.40),
    CHILISAUS("Chilisaus", 0.50),
    GEENSAUS("Geen saus", 0.0);

    private String naam;
    private Double prijs;

    SausMenu(String naam, Double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public Double getPrijs() {
        return prijs;
    }

    public static String getSausMenu()
    {
        String namen = "";
        for(SausMenu saus : values()) {
            namen += saus.naam + ": " + saus.prijs + " | ";
        }
        return namen;
    }
}