package com.example.countryservice.service;

import com.example.countryservice.entity.Country;
import com.example.countryservice.repository.CountryRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country saveCountry(Country country) {
        log.info("Inside saveCountry method of CountryService");
        return countryRepository.save(country);
    }

    @SneakyThrows
    public Country findCountryByName(String countryName) {
        log.info("Inside findCountryByName method of CountryService");
        Thread.sleep(1000);
        return countryRepository.findByName(countryName);
    }
}
