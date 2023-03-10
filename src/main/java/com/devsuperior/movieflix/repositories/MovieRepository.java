package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT obj FROM Movie obj JOIN FETCH obj.reviews WHERE obj.id = :movieID")
    Movie findMovieByReviews(Long movieID);

    @Query("SELECT obj FROM Movie obj INNER JOIN obj.genre WHERE obj.genre.id = :genreID")
    Page<Movie> findMovieByGenre(Long genreID, Pageable pageable);

    @Query("SELECT DISTINCT obj FROM Movie obj WHERE "
            + "(:genre IS NULL OR :genre = obj.genre) AND "
            + "(LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%')))")
    Page<Movie> find(Genre genre, String title, Pageable pageable);

}
