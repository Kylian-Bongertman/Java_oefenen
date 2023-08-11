public enum ProductGrootte {
    BROODJE_DONER_NORMAAL("Broodje doner Normaal", 5.0),
    BROODJE_DONER_MEGA("Broodje doner Mega", 8.0),

    DURUM_DONER_NORMAAL("Durum doner normaal", 4.5),
    DURUM_DONER_MEGA("Durum doner mega", 7.0);

    private String naam;
    private Double prijs;

    ProductGrootte(String naam, Double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Double getPrijs() {
        return this.prijs;
    }
}

