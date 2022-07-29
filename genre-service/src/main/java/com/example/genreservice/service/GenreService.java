package com.example.genreservice.service;


import com.example.genreservice.entity.Genre;
import com.example.genreservice.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre saveGenre(Genre genre) {
        log.info("Inside saveGenre method of GenreService");
        return genreRepository.save(genre);
    }

    public Genre findGenreByName(String genreName) {
        log.info("Inside findGenreByName method of GenreService");
        return genreRepository.findByName(genreName);
    }
}
