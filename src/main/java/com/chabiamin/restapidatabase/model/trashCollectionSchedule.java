package com.chabiamin.restapidatabase.model;

import jakarta.persistence.*;

@Entity
@Table(name="trashCollectionSchedule")
public class trashCollectionSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    @Column(name="day")

    String day ;
    @Column(name="timeslot")

    String timeSlot ;
    @Column(name="date")

    String Date ;
    @Column(name="availability")

    String availability;

    public trashCollectionSchedule() {
    }

    public trashCollectionSchedule(int id, String day, String timeSlot, String date, String availability) {
        this.id = id;
        this.day = day;
        this.timeSlot = timeSlot;
        Date = date;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
