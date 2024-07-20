package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.service.cleanTaskServiceImp;
import com.chabiamin.restapidatabase.service.reportsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class driverApi {


    @Autowired
    cleanTaskServiceImp cleanTaskServiceImp;

    @Autowired
    public driverApi(cleanTaskServiceImp cleanTaskServiceImp) {
        this.cleanTaskServiceImp = cleanTaskServiceImp;
    }

    @GetMapping("/{driverId}/tasks")
    public List<cleanTask> getTasksByDriverId(@PathVariable int driverId){

            return cleanTaskServiceImp.getTasksbyDriverId(driverId);



    }
    @PatchMapping ("/{driverId}/{taskId}/update-task-status")
    public ResponseEntity<String> UpdateTaskbyID(@PathVariable int taskId, @RequestParam String status){

        cleanTaskServiceImp.updateTaskStatus(taskId,status);

        return new ResponseEntity<>("task update status operation done with success", HttpStatus.ACCEPTED);

    }
}
