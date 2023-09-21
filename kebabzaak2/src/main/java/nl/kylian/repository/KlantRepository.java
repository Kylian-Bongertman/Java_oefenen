package nl.kylian.repository;

import nl.kylian.model.Klant;;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KlantRepository extends CrudRepository<Klant, Long> {
    List<Klant> findByNaam(String naam);
}
