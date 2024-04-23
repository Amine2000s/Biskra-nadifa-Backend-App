package com.chabiamin.restapidatabase.model;

import jakarta.persistence.*;
import lombok.Builder;

import javax.imageio.ImageIO;
import java.time.LocalDateTime;

@Entity
@Table(name="report")
@Builder

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    @Column(name="reporterID")
    int reporterId;
    @Column(name="report-type")
    String reportType;
    @Column(name = "report-description")
    String reportDescription;
    @Column(name="report-location")
    String reportLocation;
    @Column(name="report-longtitude")
    String reportlongtitude;
    @Column(name="report-latitude")
    String reportlatitude;
    @Column(name="report-picture")
    String image ;
    @Column(name="image-data")
    byte[] imagedata ;
    @Column(name="created-at")
    java.time.LocalDateTime createdAt ;

    public Report() {
    }

    public Report(int id, int reporterId, String reportType, String reportDescription, String reportLocation, String image,byte[] imagedata,java.time.LocalDateTime creatAt ) {
        this.id = id;
        this.reporterId = reporterId;
        this.reportType = reportType;
        this.reportDescription = reportDescription;
        this.reportLocation = reportLocation;
        this.image = image;
        this.imagedata = imagedata;
        this.createdAt = creatAt ;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportLocation() {
        return reportLocation;
    }

    public void setReportLocation(String reportLocation) {
        this.reportLocation = reportLocation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setImagedata(byte[] imagedata) {
        this.imagedata = imagedata;
    }

    public byte[] getImagedata() {
        return imagedata;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public String getReportlongtitude() {
        return reportlongtitude;
    }

    public void setReportlongtitude(String reportlongtitude) {
        this.reportlongtitude = reportlongtitude;
    }

    public String getReportlatitude() {
        return reportlatitude;
    }

    public void setReportlatitude(String reportlatitude) {
        this.reportlatitude = reportlatitude;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

