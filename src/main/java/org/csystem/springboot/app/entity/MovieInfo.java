package org.csystem.springboot.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movies")
@NoArgsConstructor
@Accessors(prefix = "m_")
@Setter
@Getter
public class MovieInfo { //POJO class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //postgresql: serial
    @Column(name="movie_id")
    private long m_id;

    @Column(name="name", nullable = false)
    private String m_name;

    @Column(name="type", nullable = false)
    private String m_type;

    @Column(name="date", nullable = false)
    private LocalDate m_date;

    @Column(name="director", nullable = false)
    private String m_director;

    @Column(name="duration", nullable = false)
    private double m_duration;

    public MovieInfo(String name, String type, LocalDate date, String director, double duration)
    {
        m_name = name;
        m_type = type;
        m_date = date;
        m_director = director;
        m_duration = duration;
    }

    public long getId()
    {
        return m_id;
    }

    public LocalDate getDate()
    {
        return m_date;
    }
}
