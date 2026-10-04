package com.project.movie_tickets.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="`show`")
public class Show {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long hallMovieId;
    private String showTime;
    private LocalDate showDate;
    public Long getId(){
    	return id;
    	}
    public void setId(Long id){
    	this.id=id;
    	}
    public Long getHallMovieId(){
    	return hallMovieId;
    	}
    public void setHallMovieId(Long h){
    	this.hallMovieId=h;
    	}
    public String getShowTime(){
    	return showTime;
    	}
    public void setShowTime(String s){
    	this.showTime=s;
    	}
    public LocalDate getShowDate(){
    	return showDate;
    	}
    public void setShowDate(LocalDate d){
    	this.showDate=d;
    	}
}