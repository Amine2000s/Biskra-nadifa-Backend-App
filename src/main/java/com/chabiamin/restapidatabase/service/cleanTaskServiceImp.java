package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.repository.cleanTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cleanTaskServiceImp implements cleanTaskService{

        cleanTaskRepository cleantaskRepository ;

    public cleanTaskServiceImp(cleanTaskRepository cleantaskRepository) {
        this.cleantaskRepository = cleantaskRepository;
    }

    public List<cleanTask> get_Tasks_by_DriverId(int driverId){

        return cleantaskRepository.findTasksByID(driverId);

    }

    public String updateTaskStatus(int taskId , String status) {

        cleantaskRepository.updateTaskStatus(status, taskId);

        return "Task Status Updated Successfully ";
    }

    @Override
    public List<cleanTask> get_AllTasks() {

        return cleantaskRepository.findAll();

    }

    @Override
    public cleanTask get_Task_byId(int taskid) {

         return  cleantaskRepository.findById(taskid).orElseThrow(()->
                  new TaskNotFoundException("Task Not Found with Id" + taskid));

    }


}
