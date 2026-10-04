package com.project.movie_tickets.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.project.movie_tickets.model.HallMovie;
//
//public interface HallMovieRepository extends JpaRepository<HallMovie, Long> {}



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.movie_tickets.model.HallMovie;

@Repository
public interface HallMovieRepository extends JpaRepository<HallMovie, Long> {
    List<HallMovie> findByMovieId(Long movieId);
}