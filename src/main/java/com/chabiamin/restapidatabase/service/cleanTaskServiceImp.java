package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.model.driver;
import com.chabiamin.restapidatabase.repository.cleanTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cleanTaskServiceImp {

        cleanTaskRepository cleantaskRepository ;

    public cleanTaskServiceImp(cleanTaskRepository cleantaskRepository) {
        this.cleantaskRepository = cleantaskRepository;
    }

    public List<cleanTask> getAllTasksbyDriverId(Optional<driver> Driver){

        driver driver = Driver.get();
        return cleantaskRepository.findTasksByID(driver);


    }

    public void updateTaskStatus(int taskId , String status){

        cleantaskRepository.updateTaskStatus(status,taskId);



    }


}
