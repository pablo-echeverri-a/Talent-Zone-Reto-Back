package com.co.sofka.talentzone.backend.reto.tourfrancia.repositories;

import java.util.Optional;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	Optional<Country> findCountryByCode(String code);
}
