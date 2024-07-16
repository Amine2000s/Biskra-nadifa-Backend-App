package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.repository.driverRepository;
import org.springframework.stereotype.Component;

import java.util.List;
public interface dashboardService {



    public String CreateTask(int reportid , int systemUserId , int driverId);
    public String changeassinedDriver(int id , int newDriverId);

    public List<normalUser> getAllCitizens();
    public List<systemUser> getAllSystemUsers();


}
