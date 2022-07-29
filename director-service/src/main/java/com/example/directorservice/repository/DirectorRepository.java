package com.example.directorservice.repository;

import com.example.directorservice.entity.Director;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    @NewSpan
    Director findByDirectorId(int directorId);
}
