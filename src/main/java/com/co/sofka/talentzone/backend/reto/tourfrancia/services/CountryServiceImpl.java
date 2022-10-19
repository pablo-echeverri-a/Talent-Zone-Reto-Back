package com.co.sofka.talentzone.backend.reto.tourfrancia.services;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CountryDTO;
import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.Country;
import com.co.sofka.talentzone.backend.reto.tourfrancia.repositories.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CountryDTO> findAllCountries() {
        List<CountryDTO> countries = new ArrayList<>();
        countryRepository.findAll().forEach(country -> {
            CountryDTO countryDTO = modelMapper.map(country, CountryDTO.class);
            countries.add(countryDTO);
        });
        return countries;
    }

    @Override
    public CountryDTO findCountryByCode(String code) {
        CountryDTO countryDTO = modelMapper.map(countryRepository.findCountryByCode(code), CountryDTO.class);
        return countryDTO;
    }

    @Override
    public CountryDTO saveCountry(CountryDTO country) {
        Country newCountry = modelMapper.map(country, Country.class);
        return modelMapper.map(countryRepository.save(newCountry), CountryDTO.class);
    }

    @Override
    public CountryDTO updateCountry(CountryDTO updateCountry, int id) {

        Country updatedCountry = countryRepository.findById(id).map(country -> {
            country.setName(updateCountry.getName());
            country.setCode(updateCountry.getCode());
            return countryRepository.save(country);
        }).orElseGet(() -> countryRepository.save(modelMapper.map(updateCountry, Country.class)));

        return modelMapper.map(updatedCountry, CountryDTO.class);
    }

    @Override
    public void deleteCountry(int id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        }
    }

}
