package nl.kylian.controller.rest;

import nl.kylian.controller.exception.ProductNotFoundException;
import nl.kylian.model.Bestelling;
import nl.kylian.repository.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bestellingen")
public class BestellingRestController {

    @Autowired
    private BestellingRepository bestellingRepository;

    @GetMapping
    public Iterable<Bestelling> findAll() { return bestellingRepository.findAll(); }

    @GetMapping("/{id}")
    public Bestelling findOne(@PathVariable Long id) {
        return bestellingRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new); //BestellingNotFoundException
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bestelling create(@RequestBody Bestelling bestelling) { return bestellingRepository.save(bestelling); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bestellingRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new); //BestellingNotFoundException
        bestellingRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Bestelling updateBestelling(@RequestBody Bestelling bestelling, @PathVariable Long id) {
        if (bestelling.getId() != id) {
            throw new ProductNotFoundException(); //BestellingNotFoundException
        }
        bestellingRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new); //BestellingNotFoundException
        return bestellingRepository.save(bestelling);
    }

}
