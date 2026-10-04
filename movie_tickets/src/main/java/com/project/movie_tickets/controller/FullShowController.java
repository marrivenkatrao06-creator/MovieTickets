package com.project.movie_tickets.controller;



//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.movie_tickets.model.Seat;
//import com.project.movie_tickets.model.Show;
//import com.project.movie_tickets.repo.SeatRepository;
//import com.project.movie_tickets.repo.ShowRepository;
//
//@RestController
//@RequestMapping("/api/show")
//public class FullShowController {
//
//    private final ShowRepository showRepo;
//    private final SeatRepository seatRepo;
//
//    public FullShowController(ShowRepository showRepo, SeatRepository seatRepo){
//        this.showRepo = showRepo;
//        this.seatRepo = seatRepo;
//    }
//
//    @PostMapping
//    public Show createShow(@RequestBody Show show){
//        Show saved = showRepo.save(show);
//        for(int i=1; i<=60; i++){
//            Seat s = new Seat();
//            s.setShowId(saved.getId());
//            s.setSeatNumber("A"+i);
//            s.setIsBooked(false);
//            seatRepo.save(s);
//        }
//        return saved;
//    }
//
//    @GetMapping
//    public List<Show> getAll(){
//        return showRepo.findAll();
//    }
//}






import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.project.movie_tickets.model.Show;
import com.project.movie_tickets.repo.ShowRepository;
import com.project.movie_tickets.model.Seat;
import com.project.movie_tickets.repo.SeatRepository;
import com.project.movie_tickets.model.HallMovie;
import com.project.movie_tickets.repo.HallMovieRepository;

@RestController
@RequestMapping("/api/show")
public class FullShowController {
    
    private final ShowRepository showRepo;
    private final SeatRepository seatRepo;
    private final HallMovieRepository hallMovieRepo;

    // Constructor - 3 repos inject chesam
    public FullShowController(ShowRepository showRepo, SeatRepository seatRepo, HallMovieRepository hallMovieRepo){
        this.showRepo = showRepo;
        this.seatRepo = seatRepo;
        this.hallMovieRepo = hallMovieRepo;
    }

    // Show create + auto 60 seats
    @PostMapping
    public Show createShow(@RequestBody Show show){
        Show saved = showRepo.save(show);
        for(int i=1; i<=60; i++){
            Seat s = new Seat();
            s.setShowId(saved.getId());
            s.setSeatNumber("A"+i);
            s.setIsBooked(false);
            seatRepo.save(s);
        }
        return saved;
    }

    @GetMapping
    public List<Show> getAll(){
        return showRepo.findAll();
    }

    // NEW API - Movie ki unna shows chupistadi
    @GetMapping("/by-movie/{movieId}")
    public List<Show> getByMovie(@PathVariable Long movieId){
        List<HallMovie> list = hallMovieRepo.findByMovieId(movieId);
        List<Long> hallMovieIds = list.stream().map(HallMovie::getId).toList();
        if(hallMovieIds.isEmpty()){
            return List.of();
        }
        return showRepo.findByHallMovieIdIn(hallMovieIds);
    }
}