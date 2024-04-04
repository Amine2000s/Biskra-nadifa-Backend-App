package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.repository.driverRepository;
import org.springframework.stereotype.Component;

import java.util.List;
public interface dashboardService {




    public List<driver> getAllDrivers();
    public List<Report> getAllReports();
    public List<sugesstion> getAllSugesstions();


    public List<normalUser> getAllCitizens() ;

    public List<cleanTask> getAllTaskCleaning();


}
