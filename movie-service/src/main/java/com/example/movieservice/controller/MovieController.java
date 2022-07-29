package com.example.movieservice.controller;


import com.example.movieservice.VO.ResponseTemplateVO;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/")
    public Movie saveMovie(@RequestBody Movie movie) {
        log.info("Inside saveMovie of MovieController");
        return movieService.saveMovie(movie);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getMovie(@PathVariable("id") int movieId) {
        log.info("Inside getMovie of MovieController");
        return movieService.getMovie(movieId);
    }

    @GetMapping
    public List<ResponseTemplateVO> getAllMovies() {
        log.info("Inside getAllMovies of MovieController");
        return movieService.getAllMovies();
    }


}
