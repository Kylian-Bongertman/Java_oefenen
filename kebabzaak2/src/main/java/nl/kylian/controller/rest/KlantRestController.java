package nl.kylian.controller.rest;


import nl.kylian.controller.exception.*;
import nl.kylian.model.Klant;

import nl.kylian.repository.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/klanten")
public class KlantRestController {

    @Autowired
    private KlantRepository klantRepository;

    @GetMapping
    public Iterable<Klant> findAll() { return klantRepository.findAll(); }

    @GetMapping("/naam/{klantNaam}")
    public List<Klant> findByNaam(@PathVariable String klantNaam) {
        return klantRepository.findByNaam(klantNaam);
    }

    @GetMapping("/{id}")
    public Klant findOne(@PathVariable Long id) {
        return klantRepository.findById(id)
                .orElseThrow(KlantNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Klant create(@RequestBody Klant klant) { return klantRepository.save(klant); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        klantRepository.findById(id)
                .orElseThrow(KlantNotFoundException::new);
        klantRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Klant updateKlant(@RequestBody Klant klant, @PathVariable Long id) {
        if (klant.getId() != id) {
            throw new KlantNotFoundException();
        }
        klantRepository.findById(id)
                .orElseThrow(KlantIdMismatchException::new);
        return klantRepository.save(klant);
    }
}