package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.model.driver;
import com.chabiamin.restapidatabase.repository.cleanTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cleanTaskServiceImp implements cleanTaskService{

        cleanTaskRepository cleantaskRepository ;

    public cleanTaskServiceImp(cleanTaskRepository cleantaskRepository) {
        this.cleantaskRepository = cleantaskRepository;
    }

    public List<cleanTask> getAllTasksbyDriverId(int driverId){


        return cleantaskRepository.findTasksByID(driverId);


    }

    public void updateTaskStatus(int taskId , String status){

        cleantaskRepository.updateTaskStatus(status,taskId);



    }


    @Override
    public void createTask(int reportId, int systemUserId, int driverId) {
            /* implmented the task ctreation in the dashboardService*/
    }

    @Override
    public List<cleanTask> getAllTasks() {
        return cleantaskRepository.findAll();
    }

    @Override
    public cleanTask getTaskbyId(int taskid) {

         return  cleantaskRepository.findById(taskid).orElseThrow(()->
                  new TaskNotFoundException("Task Not Found with Id" + taskid));

    }

    @Override
    public List<cleanTask> getTasksByDriverId(int driverId) {
        return null;
    }
}
