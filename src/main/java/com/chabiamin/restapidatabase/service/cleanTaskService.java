package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.cleanTask;

import java.util.List;

public interface cleanTaskService {



    public void createTask(int reportId,int systemUserId,int driverId);

    public List<cleanTask> getAllTasks() ;
    public cleanTask getTaskbyId(int taskid) ;

    public List<cleanTask> getTasksByDriverId(int driverId) ;

}
