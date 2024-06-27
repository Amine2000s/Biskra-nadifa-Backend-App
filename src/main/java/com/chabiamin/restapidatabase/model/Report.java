package com.chabiamin.restapidatabase.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import org.apache.commons.codec.binary.Base64InputStream;

import javax.imageio.ImageIO;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name="report")
//@Builder

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    @Column(name="reporterID")
    int reporterId;
    @Column(name="report-type")
    @Nullable

    String reportType;
    @Column(name = "report-description")
    @Nullable

    String reportDescription;
    @Column(name="report-location")
    @Nullable
    String reportLocation;
    @Column(name="report-longtitude")
    @Nullable

    String reportlongtitude;
    @Column(name="report-latitude")
    @Nullable

    String reportlatitude;
    @Column(name="report-picture")
    @Nullable

    String image ;
    @Column(name="image-data")
    @Nullable

    byte[] imagedata ;

    @Column(name="created-at")
    @Nullable

    String createdAt ;

    public Report() {
    }

    public Report(int id, int reporterId, String reportType, String reportDescription, String reportLocation, String image,byte[] imagedata,String creatAt,String reportlongtitude , String reportlatitude ) {
        this.id = id;
        this.reporterId = reporterId;
        this.reportType = reportType;
        this.reportDescription = reportDescription;
        this.reportLocation = reportLocation;
        this.image = image;
        this.imagedata = imagedata;
        this.createdAt = creatAt ;
        this.reportlongtitude = reportlongtitude ;
        this.reportlatitude = reportlatitude;
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

    public String getCreatedAt() {
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

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reporterId=" + reporterId +
                ", reportType='" + reportType + '\'' +
                ", reportDescription='" + reportDescription + '\'' +
                ", reportLocation='" + reportLocation + '\'' +
                ", reportlongtitude='" + reportlongtitude + '\'' +
                ", reportlatitude='" + reportlatitude + '\'' +
                ", image='" + image + '\'' +
                ", imagedata=" + Arrays.toString(imagedata) +
                ", createdAt=" + createdAt +
                '}';
    }
}

