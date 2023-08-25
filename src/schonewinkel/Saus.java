package schonewinkel;

public class Saus {
    private String naamSaus = "";
    private Double prijsSaus = 0.0;

    public Saus(String naamSaus, Double prijsSaus) {
        this.naamSaus = naamSaus;
        this.prijsSaus = prijsSaus;
    }

    public String getNaamSaus() {
        return naamSaus;
    }

    public Double getPrijsSaus() {
        return prijsSaus;
    }
}
