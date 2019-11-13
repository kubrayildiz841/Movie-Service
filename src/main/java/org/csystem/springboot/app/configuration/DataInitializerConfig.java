package org.csystem.springboot.app.configuration;

import org.csystem.springboot.app.entity.MovieInfo;
import org.csystem.springboot.app.repository.IMovieRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializerConfig {
    @Bean
    public ApplicationRunner initData(IMovieRepository movieRepository)
    {
        return args -> {

            if (movieRepository.count() != 0)
                return;

            movieRepository.save(new MovieInfo("Esaretin Bedeli", "Gizem-Dram",
                    LocalDate.of(1994, 1, 1), "Frank Darabont", 2.22));
            movieRepository.save(new MovieInfo("Hayalet Avcıları", "Fantastik Komedi",
                    LocalDate.of(1984, 1, 1), "Ivan Reitman", 1.47));

            movieRepository.save(new MovieInfo("Yüzüklerin Efendisi", "Fantastik",
                    LocalDate.of(2000, 1, 1), "Peter Jackson", 3.48));
        };
    }
}
