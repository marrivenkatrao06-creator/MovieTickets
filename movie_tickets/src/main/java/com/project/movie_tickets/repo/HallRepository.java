package com.project.movie_tickets.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movie_tickets.model.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {}
