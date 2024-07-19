package com.chabiamin.restapidatabase.model;

import com.chabiamin.restapidatabase.utils.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name="normal-user")
@Builder
@NoArgsConstructor
@AllArgsConstructor

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


    @Column(name="date-of-birth")
    java.time.LocalDate dateOfBirth ;
    @Column(name="gender")
    String gender;


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
