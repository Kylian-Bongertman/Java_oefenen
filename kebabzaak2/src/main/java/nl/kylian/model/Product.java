package nl.kylian.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String naam;

    @Column(nullable = false, unique = false)
    private double prijs = 0.0;

    @Column(nullable = false, unique = false)
    private double volume = 1.0;

    public Product() { //Lege constructor
    }
    public Product(String naam, double prijs, double volume) { //Gevulde constructor
        this.naam = naam;
        this.prijs = prijs;
        this.volume = volume;
    }
}
