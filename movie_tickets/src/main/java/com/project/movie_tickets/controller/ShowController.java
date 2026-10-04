package com.project.movie_tickets.controller;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie_tickets.model.Seat;
import com.project.movie_tickets.repo.SeatRepository;


@RestController
@RequestMapping("/api/shows")
public class ShowController {
    private final SeatRepository seatRepo;
    public ShowController(SeatRepository seatRepo){this.seatRepo=seatRepo;}

    @GetMapping("/{showId}/seats")
    public List<Seat> allSeats(@PathVariable Long showId){return seatRepo.findByShowId(showId);}

    @GetMapping("/{showId}/booked")
    public List<Seat> booked(@PathVariable Long showId){return seatRepo.findByShowIdAndIsBookedTrue(showId);}

    @GetMapping("/{showId}/count")
    public Map<String, Long> count(@PathVariable Long showId){
        List<Seat> all = seatRepo.findByShowId(showId);
        long booked = all.stream().filter(s->Boolean.TRUE.equals(s.getIsBooked())).count();
        Map<String, Long> m=new HashMap<>();
        m.put("total", (long)all.size());
        m.put("booked", booked);
        m.put("available", all.size()-booked);
        return m;
    }
}