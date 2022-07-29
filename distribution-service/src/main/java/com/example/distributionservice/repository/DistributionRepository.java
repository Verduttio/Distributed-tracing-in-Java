package com.example.distributionservice.repository;

import com.example.distributionservice.entity.Distribution;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, String> {
    @NewSpan
    Distribution findByName(String distributionName);
}
