package org.csystem.springboot.app.postcontruct;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.repository.IMovieRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DataInitializer {
    private final IMovieRepository m_movieRepository;

    public DataInitializer(IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }

    //@PostConstruct
    public void init()
    {
        if (m_movieRepository.count() != 0)
            return;

        m_movieRepository.save(new MovieInfo("Esaretin Bedeli", "Gizem-Dram",
                LocalDate.of(1994, 1, 1), "Frank Darabont", 2.22));
        m_movieRepository.save(new MovieInfo("Hayalet Avcıları", "Fantastik Komedi",
                LocalDate.of(1984, 1, 1), "Ivan Reitman", 1.47));

        m_movieRepository.save(new MovieInfo("Yüzüklerin Efendisi", "Fantastik",
                LocalDate.of(2000, 1, 1), "Peter Jackson", 3.48));
    }
}
