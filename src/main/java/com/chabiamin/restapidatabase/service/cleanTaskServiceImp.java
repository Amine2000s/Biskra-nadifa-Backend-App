package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.cleanTask;
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
    public Optional<cleanTask> getTaskbyId(int taskid) {
        if(cleantaskRepository.findById(taskid).isEmpty()) return null ;


        return cleantaskRepository.findById(taskid);
    }

    @Override
    public List<cleanTask> getTasksByDriverId(int driverId) {
        return null;
    }
}
