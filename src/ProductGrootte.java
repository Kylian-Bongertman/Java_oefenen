public enum ProductGrootte {
    NORMAAL("Normaal", 5.0),
    MEGA("Mega", 8.0);

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

