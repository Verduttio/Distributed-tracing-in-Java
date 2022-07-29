package com.example.genreservice.repository;

import com.example.genreservice.entity.Genre;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
    @NewSpan
    Genre findByName(String genreName);
}
