package com.project.movie_tickets.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie_tickets.model.Hall;
import com.project.movie_tickets.repo.HallRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/halls")
public class HallController {

    private final HallRepository repo;

    public HallController(HallRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Hall> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Hall getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Hall add(@RequestBody Hall hall) {
        return repo.save(hall);
    }

    @PutMapping("/{id}")
    public Hall update(@PathVariable Long id, @RequestBody Hall newHall) {
        return repo.findById(id).map(h -> {
            h.setHallName(newHall.getHallName());
            h.setTotalSeats(newHall.getTotalSeats());
            return repo.save(h);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
