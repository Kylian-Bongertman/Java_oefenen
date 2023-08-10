public enum Salade {
    SLA("Sla", 0.0),
    TOMAAT("Tomaat", 0.0),
    KOMKOMMER("Komkommer", 0.0),
    KOOL("Kool", 0.0),
    UI("Ui", 0.0),
    KAAS("Kaas", 0.0),
    AUGURK("Augurk", 0.0),
    PEPERS("Pepers", 0.0);

    private String naam;

    Salade(String naam, Double prijs) {
        this.naam = naam;
    }

    public static String getNamen()
    {
        String namen = "";
        for(Salade salade : values()) {
            namen += salade.naam + ", ";
        }
        return namen;
    }

}

