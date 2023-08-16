import java.util.concurrent.TimeUnit;

public class DonerProduct extends Product {
    protected Saus saus = null;
    protected Salade[] salades = new Salade[3]; // Je moet 3 salades kiezen
    protected int saladeCount = 0;

    DonerProduct(String productKeuze) {
        kiesGrootte(productKeuze); // Normaal of Mega grootte
        kiesSaus(); // Saus toevoegen
        kiesSalade(); // Salade toevoegen
        maakProduct(productKeuze); // product maken voor klant
    }

    private void maakProduct(String productKeuze) {
        if(productKeuze.equals("BROODJE_DONER_")) {
            System.out.println("Broodje wordt nu gemaakt!");
        }
        else if (productKeuze.equals("DURUM_DONER_")) {
            System.out.println("Durum doner gaat nu in het tostiapparaat!");
            for(int i=5; i>0; i--) { //Countdown van 5 seconden wanneer Durum in het tostiapparaat zit
                System.out.print(i + ".. ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Uw Durum doner is klaar!");
        }
    }

    private void kiesSalade() {
        System.out.println("Welke salade wil je? (Je mag er 3 kiezen). We hebben: " + Salade.getNamen());
        for (int i = 0; i < 3; i++) {
            String gekozenSaladeString = scanner.nextLine();
            addSalade(Salade.valueOf(gekozenSaladeString.toUpperCase()));
        }
        System.out.println("De gekozen salades zijn: " + getSalades());
    }

    private void kiesSaus() {
        System.out.println("Kies de saus die je wilt toevoegen: " + Saus.getNamen());
        String gekozenSausString = scanner.nextLine();
        setSaus(Saus.valueOf(gekozenSausString.toUpperCase()));

        System.out.println("De gekozen saus is: " + getSaus());
    }

    @Override
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

    public void addSalade(Salade salade) {
        this.salades[saladeCount] = salade;
        saladeCount++;
    }

    public String getSalades() {
        String saladeString = "";
        for(Salade salade : salades) {
            saladeString += salade.name() + ", ";
        }
        return saladeString;
    }
}

//Feature requests:
//Doner donderdag 1 euro korting

//Durum doner moet een inTostiApparaat methode hebben.

//Extra saus mogelijkheid

