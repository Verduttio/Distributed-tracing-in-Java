package com.example.movieservice.service;

import com.example.movieservice.VO.Genre;
import com.example.movieservice.VO.ResponseTemplateVO;
import com.example.movieservice.VO.objectResponses.DirectorResponse;
import com.example.movieservice.VO.objectResponses.DistributionResponse;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Movie saveMovie(Movie movie) {
        log.info("Inside saveMovie of MovieService");
        return movieRepository.save(movie);
    }

    public ResponseTemplateVO getMovie(int movieId) {
        log.info("Inside getMovie of MovieService");
        Movie movie = movieRepository.findByMovieId(movieId);

        return getMovieResponseTemplate(movie);
    }

    private ResponseTemplateVO getMovieResponseTemplate(Movie movie) {
        log.info("Inside MovieResponseTemplate of MovieService");
        ResponseTemplateVO vo = new ResponseTemplateVO();

        Genre genre =
                restTemplate.getForObject("http://GENRE-SERVICE/genres/" + movie.getGenre(), Genre.class);

        DirectorResponse directorResponse =
                restTemplate.getForObject("http://DIRECTOR-SERVICE/directors/" + movie.getDirectorId(), DirectorResponse.class);

        DistributionResponse distributionResponse =
                restTemplate.getForObject("http://DISTRIBUTION-SERVICE/distributions/" + movie.getDistribution(), DistributionResponse.class);


        vo.setMovieId(movie.getMovieId());
        vo.setTitle(movie.getTitle());
        vo.setGenre(genre);
        vo.setYear(movie.getYear());
        vo.setDirector(directorResponse);
        vo.setDistribution(distributionResponse);

        return vo;
    }

    public List<ResponseTemplateVO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        ArrayList<ResponseTemplateVO> output = new ArrayList<>();
        for(var movie : movies) {
            output.add(getMovieResponseTemplate(movie));
        }

        return output;
    }
}
