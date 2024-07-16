package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.cleanTask;

import java.util.List;

public interface cleanTaskService {




    public List<cleanTask> getAllTasks() ;
    public cleanTask getTaskbyId(int taskid) ;

    public List<cleanTask> getTasksbyDriverId(int driverId) ;

}
