package com.chabiamin.restapidatabase.model;


import jakarta.persistence.*;

@Entity
@Table(name="modernBin")
public class modernBin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Column(name="latitude")
    double latitude;

    @Column(name="longtitude")
    double longtitude;

    @Column(name="status")
    String status;

    public modernBin() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
