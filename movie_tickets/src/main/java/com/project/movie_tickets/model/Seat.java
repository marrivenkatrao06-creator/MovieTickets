package com.project.movie_tickets.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Seat {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long showId;
    private String seatNumber;
    private Boolean isBooked=false;
    private String bookedBy;
    private String phone;
    public Long getId(){
    	return id;
    	}
    public void setId(Long id){
    	this.id=id;
    	}
    public Long getShowId(){
    	return showId;
    	}
    public void setShowId(Long s){
    	this.showId=s;
    	}
    public String getSeatNumber(){
    	return seatNumber;
    	}
    public void setSeatNumber(String s){
    	this.seatNumber=s;
    	}
    public Boolean getIsBooked(){
    	return isBooked;
    	}
    public void setIsBooked(Boolean b){
    	this.isBooked=b;
    	}
    public String getBookedBy(){
    	return bookedBy;
    	}
    public void setBookedBy(String b){
    	this.bookedBy=b;
    	}
    public String getPhone(){
    	return phone;
    	}
    public void setPhone(String p){
    	this.phone=p;
    	}
}