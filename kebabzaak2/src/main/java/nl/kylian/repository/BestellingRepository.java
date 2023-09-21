package nl.kylian.repository;

import nl.kylian.model.Bestelling;
import org.springframework.data.repository.CrudRepository;

public interface BestellingRepository extends CrudRepository<Bestelling, Long> {
}
