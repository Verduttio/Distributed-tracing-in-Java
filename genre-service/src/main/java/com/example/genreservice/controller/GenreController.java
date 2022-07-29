package com.example.genreservice.controller;


import com.example.genreservice.entity.Genre;
import com.example.genreservice.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
@Slf4j
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/")
    public Genre saveGenre(@RequestBody Genre genre) {
        log.info("Inside saveGenre method of GenreController");
        return genreService.saveGenre(genre);
    }

    @GetMapping("/{name}")
    public Genre findGenreByName(@PathVariable("name") String genreName) {
        log.info("Inside findGenreByName method of GenreController");
        log.info("genreName: " + genreName);
        return genreService.findGenreByName(genreName);
    }


}
