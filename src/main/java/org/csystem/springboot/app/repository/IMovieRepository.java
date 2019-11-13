package org.csystem.springboot.app.repository;

import org.csystem.springboot.app.entity.MovieInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<MovieInfo, Long> {
    @Query(value = "select * from movies where date_part('year', date)=:year", nativeQuery = true)
    Iterable<MovieInfo> findByYear(int year);

    @Query(value = "select * from movies where date_part('year', date) between :start and :end", nativeQuery = true)
    Iterable<MovieInfo> findByYears(int start, int end);

    @Query("from MovieInfo mi where mi.m_name like ?1%")
    Iterable<MovieInfo> findByNameStartsWith(String name);

    @Query("from MovieInfo mi where mi.m_name like %?1%")
    Iterable<MovieInfo> findByNameContaining(String name);
}
