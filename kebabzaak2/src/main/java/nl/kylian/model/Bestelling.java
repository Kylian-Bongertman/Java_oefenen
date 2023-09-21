package nl.kylian.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> producten = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "klant_id") // Specify the appropriate column name
    private Klant klant;
    }



//@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
//private long id;
//
//    //    @Column(nullable = false, unique = false)
//    //    private ArrayList<Product> producten = new ArrayList<>();
//
//@OneToMany(cascade = CascadeType.ALL) // Specify cascade type based on your requirements
//private List<Product> producten = new ArrayList<>();
//
//    //    @Column(nullable = false, unique = false)
//    //    private Klant klant;
//
//@ManyToOne
//private Klant klant;
