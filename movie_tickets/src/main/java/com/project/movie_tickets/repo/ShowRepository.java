package com.project.movie_tickets.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.project.movie_tickets.model.Show;
//
//public interface ShowRepository extends JpaRepository<Show, Long> {}





import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.movie_tickets.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByHallMovieIdIn(List<Long> ids);
}
