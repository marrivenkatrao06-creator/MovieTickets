package com.project.movie_tickets.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="hall_movie")
public class HallMovie {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long hallId;
    private Long movieId;
    public Long getId(){
    	return id;
    	}
    public void setId(Long id){
    	this.id=id;
    	}
    public Long getHallId(){
    	return hallId;
    	}
    public void setHallId(Long hallId){
    	this.hallId=hallId;

    }
    public Long getMovieId(){
    	return movieId;
    	}
    public void setMovieId(Long movieId){
    	this.movieId=movieId;
    	}
}