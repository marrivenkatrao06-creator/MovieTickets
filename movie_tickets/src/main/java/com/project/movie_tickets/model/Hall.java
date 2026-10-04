package com.project.movie_tickets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "hall")
public class Hall {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String hallName;
    private int totalSeats=60;
    public Long getId(){
    	return id;
    	}
    public void setId(Long id){
    	this.id=id;
    	}
    public String getHallName(){
    	return hallName;
    	}
    public void setHallName(String h){
    	this.hallName=h;
    	}
    public int getTotalSeats(){
    	return totalSeats;
    	}

    public void setTotalSeats(int t){
    	this.totalSeats=t;
    	}
}