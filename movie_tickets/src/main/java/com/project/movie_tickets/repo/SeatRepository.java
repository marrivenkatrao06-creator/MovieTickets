package com.project.movie_tickets.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movie_tickets.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowId(Long showId);
    List<Seat> findByShowIdAndIsBookedTrue(Long showId);
}
