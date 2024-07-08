package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.repository.driverRepository;
import com.chabiamin.restapidatabase.service.cleanTaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class driverApi {

    cleanTaskServiceImp cleanTaskServiceImp;


    @Autowired
    public driverApi(cleanTaskServiceImp cleanTaskServiceImp) {
        this.cleanTaskServiceImp = cleanTaskServiceImp;
    }

    @GetMapping("/{driverId}/tasks")
    public List<cleanTask> getTasksByDriverId(@PathVariable int driverId){

            return cleanTaskServiceImp.getAllTasksbyDriverId(driverId);



    }
    @PatchMapping ("/{driverId}/{taskId}/update-task-status")
    public String UpdateTaskbyID(@PathVariable int taskId,@RequestParam String status){

        cleanTaskServiceImp.updateTaskStatus(taskId,status);

        return "task update status operation done with success";

    }
}
