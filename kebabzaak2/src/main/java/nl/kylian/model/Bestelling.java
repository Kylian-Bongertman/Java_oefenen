package nl.kylian.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private ArrayList<Product> producten = new ArrayList<>();

    @Column(nullable = false, unique = false)
    private Klant klant;
}
