package com.example.countryservice.repository;

import com.example.countryservice.entity.Country;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    @NewSpan
    Country findByName(String countryName);
}
