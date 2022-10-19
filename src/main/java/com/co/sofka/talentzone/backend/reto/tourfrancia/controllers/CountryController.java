package com.co.sofka.talentzone.backend.reto.tourfrancia.controllers;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CountryDTO;
import com.co.sofka.talentzone.backend.reto.tourfrancia.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/all")
    public ResponseEntity<List<CountryDTO>> findAllCountries() {
        List<CountryDTO> countries;
        countries = service.findAllCountries();

        return ResponseEntity.ok().body(countries);

    }

    @GetMapping("/country/{code}")
    public ResponseEntity<CountryDTO> findCountryByCode(@PathVariable(name = "code") String code) {

        CountryDTO countryDTO = service.findCountryByCode(code);

        if (countryDTO.getCode().equals(code)) {
            return ResponseEntity.ok().body(countryDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/newCountry")
    public ResponseEntity<CountryDTO> saveCountry(@Validated @RequestBody CountryDTO country) {
        CountryDTO newCountry = service.saveCountry(country);
        return ResponseEntity.created(URI.create("/api/countries/newCountry/".concat(String.valueOf(newCountry.getId())))).body(newCountry);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO newCountry, @PathVariable int id) {
        try {
            CountryDTO countryDTO = service.updateCountry(newCountry, id);

            return ResponseEntity.created(URI.create("/api/countries/update/".concat(String.valueOf(newCountry.getId())))).body(countryDTO);

        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable int id) {
        try {
            service.deleteCountry(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
