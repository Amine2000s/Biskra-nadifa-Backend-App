package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.*;

import java.util.List;
public interface dashboardService {



    public String Create_Task(int reportid , int systemUserId , int driverId);
    public String change_assigned_Driver(int id , int newDriverId);

    public List<normalUser> get_All_Citizens();
    public List<systemUser> get_All_SystemUsers();


}
