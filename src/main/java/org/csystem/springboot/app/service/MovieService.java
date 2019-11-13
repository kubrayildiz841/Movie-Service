package org.csystem.springboot.app.service;

import org.apache.coyote.Request;
import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.repository.IMovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    private final IMovieRepository m_movieRepository;

    public MovieService(IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }

    @Override
    public Iterable<MovieInfo> getMovies()
    {
        return m_movieRepository.findAll();
    }

    @Override
    public Optional<MovieInfo> getById(long id)
    {
        return m_movieRepository.findById(id);
    }

    @Override
    public Iterable<MovieInfo> getByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }

    @Override
    public Iterable<MovieInfo> getByYears(int start, int end)
    {
        return m_movieRepository.findByYears(start, end);
    }

    @Override
    public Iterable<MovieInfo> getByNameStartsWith(String name)
    {
        return m_movieRepository.findByNameStartsWith(name);
    }

    @Override
    public Iterable<MovieInfo> getByNameContaining(String name)
    {
        return m_movieRepository.findByNameContaining(name);
    }

    @Override
    public MovieInfo save(MovieInfo movieInfo)
    {
        return m_movieRepository.save(movieInfo);
    }
}
