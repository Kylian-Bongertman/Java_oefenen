package nl.kylian.repository;

import nl.kylian.model.Klant;
import org.springframework.data.repository.CrudRepository;

public interface KlantRepository extends CrudRepository<Klant, Long> {
}
