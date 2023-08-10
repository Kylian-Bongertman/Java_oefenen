public enum Saus implements Ingredient {
    KNOFLOOKSAUS("Knoflooksaus", 0.50),
    SAMBAL("Sambal", 0.30),
    CHILISAUS("Chilisaus", 0.40),
    GEENSAUS("Geen saus", 0.0);

    private String naam;
    private Double prijs;

    Saus(String naam, Double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public static String getNamen()
    {
        String namen = "";
        for(Saus saus : values()) {
            namen += saus.naam + ", ";
        }
        return namen;
    }

    @Override
    public Double getPrijs() {
        return this.prijs;
    }
}

