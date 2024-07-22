package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.service.cleanTaskServiceImp;
import com.chabiamin.restapidatabase.service.reportsServiceImp;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation(description = "Get the task assigned to the driver Id ")
    @GetMapping("/{driverId}/tasks")
    public List<cleanTask> get_Tasks_By_DriverId(@PathVariable int driverId){

            return cleanTaskServiceImp.get_Tasks_by_DriverId(driverId);



    }
    @Operation(description = "Update the task Status ")

    @PatchMapping ("/{driverId}/{taskId}/update-task-status")
    public ResponseEntity<String> Update_TaskStatus_byId(@PathVariable int taskId, @RequestParam String status){

        cleanTaskServiceImp.updateTaskStatus(taskId,status);

        return new ResponseEntity<>("task update status operation done with success", HttpStatus.ACCEPTED);

    }
}
