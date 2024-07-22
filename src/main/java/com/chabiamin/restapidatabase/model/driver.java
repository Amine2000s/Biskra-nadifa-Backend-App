package com.chabiamin.restapidatabase.model;

import com.chabiamin.restapidatabase.utils.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
 @NoArgsConstructor
@Table(name="driver")

public class driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="suggesterID")
     Set<cleanTask> tasks  ;


    @Column(name="name")
    String name ;
    @Column(name="surname")
    String surName ;
    @Column(name="phone-number")
    String phoneNumber ;
    @Column(name="hashed-password")
    String hashedPassword ;
    @Column(name="status")
    String status ;
    @Column(name="plate-number")
    String plateNumber;
    @Column(name="date-of-birth")
    String dateOfBirth ;

    @Column(name="gender")
    String gender;

    public driver(int id,
                  String name,
                  String surName,
                  String phoneNumber,
                  String hashedPassword,
                  String status,
                  String dateOfBirth,
                  String plateNo,
                  String gender) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashedPassword;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.plateNumber = plateNo;
        this.gender = gender;
      //  this.tasks = tasks ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

/*   public List<cleanTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<cleanTask> tasks) {
        this.tasks = tasks;
    }*/
}
