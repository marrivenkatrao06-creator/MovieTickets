package com.project.movie_tickets.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie_tickets.model.HallMovie;
import com.project.movie_tickets.repo.HallMovieRepository;

@RestController
@RequestMapping("/api/hall-movies")
public class HallMovieController {
    private final HallMovieRepository repo;
    public HallMovieController(HallMovieRepository repo){this.repo=repo;}

    @GetMapping
    public List<HallMovie> getAll(){return repo.findAll();}

    @PostMapping
    public HallMovie add(@RequestBody HallMovie hm){
        return repo.save(hm);
    }
}