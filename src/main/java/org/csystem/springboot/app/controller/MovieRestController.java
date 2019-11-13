package org.csystem.springboot.app.controller;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/moviesrest")
public class MovieRestController {
    private final IMovieService m_movieService;

    public MovieRestController(IMovieService movieService)
    {
        m_movieService = movieService;
    }

    @GetMapping
    public Iterable<MovieInfo> getMovies()
    {
        return m_movieService.getMovies();
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieInfo> getById(@PathVariable("id") long id)
    {
        var movieOptional = m_movieService.getById(id);

        //return movieOptional.isPresent() ? ResponseEntity.ok(movieOptional.get()) : ResponseEntity.notFound().build();
        //return movieOptional.isPresent() ? ResponseEntity.ok(movieOptional.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.of(m_movieService.getById(id)); //optional empty ise notfound işaretlenir
    }

    @GetMapping("/year")
    public Iterable<MovieInfo> getByYear(
            @RequestParam(value = "year", required = false, defaultValue = "0") int movieYear)
    {
        if (movieYear == 0)
            return getByYear(LocalDate.now().getYear());

        return m_movieService.getByYear(movieYear);
    }

    @GetMapping("/reqyear")
    public Iterable<MovieInfo> getByYearRequired(
            @RequestParam(value = "year") int movieYear)
    {
        return m_movieService.getByYear(movieYear);
    }

    @GetMapping("/years")
    public Iterable<MovieInfo> getByYears(@RequestParam("start") int start,
                                          @RequestParam(value = "end", required = false, defaultValue = "0") int end)
    {
        if (end == 0)
            return getByYear(start);

        return m_movieService.getByYears(start, end);
    }

    @GetMapping("/namestarts")
    public Iterable<MovieInfo> getByNameStartsWith(@RequestParam("name") String name)
    {
        return m_movieService.getByNameStartsWith(name);
    }

    @GetMapping("/namecontaining")
    public Iterable<MovieInfo> getByNameContaining(@RequestParam(value = "name", required = false) String name)
    {
        if (name == null)
            return getMovies();

        return m_movieService.getByNameContaining(name);
    }

    @PostMapping
    public MovieInfo saveRestMovie(@RequestBody MovieInfo movieInfo)
    {
        m_movieService.save(movieInfo);

        return movieInfo;
    }

    @PostMapping("/saverestlist")
    public Iterable<MovieInfo> saveRestList(@RequestBody MovieInfo movieInfo)
    {
        m_movieService.save(movieInfo);

        return getMovies();
    }

    @PostMapping("/saveuri")
    public MovieInfo saveRestUri(@RequestBody MovieInfo movieInfo, UriComponentsBuilder uriComponentsBuilder)
    {
        m_movieService.save(movieInfo);

        URI uri = uriComponentsBuilder.path("/movie/{id}").build(movieInfo.getId());

        return ResponseEntity.created(uri).body(movieInfo).getBody();
    }

    @PostMapping("/savegetlistyear")
    public Iterable<MovieInfo> saveRestListYear(@RequestBody MovieInfo movieInfo)
    {
        m_movieService.save(movieInfo);

        return getByYear(movieInfo.getDate().getYear());
    }
}
