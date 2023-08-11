import java.util.Scanner;

public class DonerProduct {
    protected Saus saus = null;
    protected ProductGrootte productGrootte = null;
    protected Salade[] salades = new Salade[3];
    protected int saladeCount = 0;

    DonerProduct(String productKeuze) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies de grootte van de bestelling (Normaal/Mega):");
        String gekozenGrootteString = scanner.nextLine();
        ProductGrootte grootte = ProductGrootte.valueOf(productKeuze + gekozenGrootteString.toUpperCase()); //kan DURUM_DONER_ of BROODJE zijn afhankelijk van keuze
        setProductGrootte(grootte);

        System.out.println("Kies de saus die je wilt toevoegen: " + Saus.getNamen());
        String gekozenSausString = scanner.nextLine();
        setSaus(Saus.valueOf(gekozenSausString.toUpperCase()));

        System.out.println("De gekozen saus is: " + getSaus());

        System.out.println("Welke salade wil je? " + Salade.getNamen());
        for (int i = 0; i < 3; i++) {
            String gekozenSaladeString = scanner.nextLine();
            addSalade(Salade.valueOf(gekozenSaladeString.toUpperCase()));
        }
        System.out.println(getSalades());

    }

    public Double getPrijs() {
        Double totaalPrijs = 0.0;
        totaalPrijs = productGrootte.getPrijs();
        totaalPrijs += saus.getPrijs();
        return totaalPrijs;
    }

    public Saus getSaus() {
        return saus;
    }

    public void setSaus(Saus gekozenSaus) {
        this.saus = gekozenSaus;
    }

    public ProductGrootte getProductGrootte() {
        return productGrootte;
    }

    public void setProductGrootte(ProductGrootte productGrootte) {
        this.productGrootte = productGrootte;
    }

    public void addSalade(Salade salade) {
        this.salades[saladeCount] = salade;
        saladeCount++;
    }

    public String getSalades() {
        String saladeString = "";
        for(Salade salade : salades) {
            saladeString += salade.name();
        }
        return saladeString;
    }
}

//Feature requests:
//Doner donderdag 1 euro korting

