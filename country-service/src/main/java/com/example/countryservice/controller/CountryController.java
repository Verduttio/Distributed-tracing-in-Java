package com.example.countryservice.controller;


import com.example.countryservice.entity.Country;
import com.example.countryservice.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
@Slf4j
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/")
    public Country saveCountry(@RequestBody Country country) {
        log.info("Inside saveCountry method of CountryController");
        return countryService.saveCountry(country);
    }

    @GetMapping("/{name}")
    public Country findCountryByName(@PathVariable("name") String countryName) {
        log.info("Inside findCountryByName method of CountryController");
        return countryService.findCountryByName(countryName);
    }

}
