package com.co.sofka.talentzone.backend.reto.tourfrancia.services;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CountryDTO;

import java.util.List;

public interface CountryService {
    public List<CountryDTO> findAllCountries();

    public CountryDTO findCountryByCode(String code);

    public CountryDTO saveCountry(CountryDTO country);

    public CountryDTO updateCountry(CountryDTO country, int id);

    public void deleteCountry(int id);
}
