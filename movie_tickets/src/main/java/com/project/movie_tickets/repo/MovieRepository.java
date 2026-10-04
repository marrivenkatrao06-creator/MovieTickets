package com.project.movie_tickets.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movie_tickets.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	}


