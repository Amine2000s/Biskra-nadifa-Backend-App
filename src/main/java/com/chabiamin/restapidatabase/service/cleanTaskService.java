package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.cleanTask;

import java.util.List;
import java.util.Optional;

public interface cleanTaskService {



    public void createTask(int reportId,int systemUserId,int driverId);

    public List<cleanTask> getAllTasks() ;
    public Optional<cleanTask> getTaskbyId(int taskid) ;

    public List<cleanTask> getTasksByDriverId(int driverId) ;

}
