package com.project.movie_tickets.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie_tickets.model.Movie;
import com.project.movie_tickets.repo.MovieRepository;


    @CrossOrigin(origins = "http://localhost:3000")
    @RestController
	@RequestMapping("/api/movies")
	public class MovieController {

	    private final MovieRepository repo;
	    public MovieController(MovieRepository repo) {
	        this.repo = repo;
	    }

	    @GetMapping
	    public List<Movie> getAll() {
	        return repo.findAll();
	    }

	    @PostMapping
	    public Movie add(@RequestBody Movie m) {
	        return repo.save(m);
	    }
	}


