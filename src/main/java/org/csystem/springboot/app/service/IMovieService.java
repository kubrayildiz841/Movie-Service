package org.csystem.springboot.app.service;

import org.csystem.springboot.app.entity.MovieInfo;

import java.util.Optional;

public interface IMovieService {
    Iterable<MovieInfo> getMovies();
    Optional<MovieInfo> getById(long id);
    Iterable<MovieInfo> getByYear(int year);
    Iterable<MovieInfo> getByYears(int start, int end);
    Iterable<MovieInfo> getByNameStartsWith(String name);
    Iterable<MovieInfo> getByNameContaining(String name);
    MovieInfo save(MovieInfo movieInfo);
}
