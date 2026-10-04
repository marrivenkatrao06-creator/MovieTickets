package com.project.movie_tickets.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.movie_tickets.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
