package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.cleanTask;

import java.util.List;

public interface cleanTaskService {




    public List<cleanTask> get_AllTasks() ;
    public cleanTask get_Task_byId(int taskid) ;

    public List<cleanTask> get_Tasks_by_DriverId(int driverId) ;

}
