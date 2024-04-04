package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.repository.driverRepository;
import com.chabiamin.restapidatabase.service.cleanTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class driverApi {

    cleanTaskService cleanTaskService ;

    driverRepository driverrepository ;

    @Autowired
    public driverApi(com.chabiamin.restapidatabase.service.cleanTaskService cleanTaskService,
                     driverRepository driverrepository) {
        this.cleanTaskService = cleanTaskService;
        this.driverrepository = driverrepository;
    }

    @GetMapping("/{driverId}/tasks")
    public List<cleanTask> getTasksByDriverId(@PathVariable int driverId){

            return cleanTaskService.getAllTasksbyDriverId(driverrepository.findById(driverId));



    }
    @PatchMapping ("/{driverId}/{taskId}/update-task-status")
    public String UpdateTaskbyID(@PathVariable int taskId,@RequestParam String status){

        cleanTaskService.updateTaskStatus(taskId,status);

        return "task update status operation done with success";

    }
}
