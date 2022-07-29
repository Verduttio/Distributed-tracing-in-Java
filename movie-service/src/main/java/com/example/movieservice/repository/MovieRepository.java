package com.example.movieservice.repository;


import com.example.movieservice.entity.Movie;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @NewSpan
    Movie findByMovieId(@SpanTag("DATABASE") int movieId);
}
