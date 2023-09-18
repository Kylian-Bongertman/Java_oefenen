package nl.kylian.repository;

import nl.kylian.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNaam(String naam);
}

