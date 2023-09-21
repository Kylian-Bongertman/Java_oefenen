package nl.kylian.controller.rest;

import nl.kylian.controller.exception.ProductIdMismatchException;
import nl.kylian.controller.exception.ProductNotFoundException;
import nl.kylian.model.Product;
import nl.kylian.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producten")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/naam/{productNaam}")
    public List<Product> findByNaam(@PathVariable String productNaam) {
        return productRepository.findByNaam(productNaam);
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
//        Product appel = new Product("appel", 1.0, 1.0);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        if (product.getId() != id) {
            throw new ProductIdMismatchException();
        }
        productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        return productRepository.save(product);
    }
}
