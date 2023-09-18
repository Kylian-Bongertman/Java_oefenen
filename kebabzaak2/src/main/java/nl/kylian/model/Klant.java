package nl.kylian.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Klant {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private String naam;
}
