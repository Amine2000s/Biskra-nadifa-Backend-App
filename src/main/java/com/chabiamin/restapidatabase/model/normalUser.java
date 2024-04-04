package com.chabiamin.restapidatabase.model;

import com.chabiamin.restapidatabase.utils.Gender;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="normal-user")

public class normalUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id ;
    @Column(name="name")
    String name ;
    @Column(name="surname")
    String surName ;
    @Column(name="phone-number")

    String phoneNumber ;
    @Column(name="hashed-password")
    String hashedPassword ;
    @Column(name="date-of-birth")
    java.time.LocalDate dateOfBirth ;
    @Column(name="gender")
    String gender;




    public normalUser() {
    }

    public normalUser(int id, String name, String surName, String phoneNumber, String hashedPassword, java.time.LocalDate dateOfBirth, String gender) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashedPassword;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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



    public java.time.LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.time.LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
