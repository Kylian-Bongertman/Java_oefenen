package kebabzaak;

public class Saus {
    private final String naamSaus;
    private final Double prijsSaus;

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
