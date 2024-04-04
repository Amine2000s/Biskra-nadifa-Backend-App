package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.service.dashboardServiceImp;
import com.chabiamin.restapidatabase.service.reportServiceImp;
import org.springframework.web.bind.annotation.*;

import java.sql.Driver;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class dashboardApi {

    reportServiceImp reportServiceImp ;

    dashboardServiceImp dashboardserviceimp;

    public dashboardApi(reportServiceImp reportServiceImp1, dashboardServiceImp dashboardserviceimp){

        this.reportServiceImp = reportServiceImp1 ;
        this.dashboardserviceimp = dashboardserviceimp ;
    }

    @GetMapping("/drivers")
    public List<driver> getAllDrivers(){


        return dashboardserviceimp.getAllDrivers() ;
    }

    @GetMapping("/reports")
    public List<Report> getAllReports(){

        return  reportServiceImp.getAllReports();
    }

    @GetMapping("/suggestions")
    public List<sugesstion> getAllSugesstion(){

        return dashboardserviceimp.getAllSugesstions() ;
    }

    @GetMapping("/tasks")
    public List<cleanTask> getAllCleaningTasks(){

        return dashboardserviceimp.getAllTaskCleaning() ;
    }

    @GetMapping("/tasks/{taskId}")
    public cleanTask getTasksbyID(@PathVariable int taskId){


        return dashboardserviceimp.getTaskbyID(taskId) ;
    }

    @PostMapping("/tasks")
    public String createTask(@RequestParam int reportId , int assignerId,int assignedId ){

        dashboardserviceimp.CreateTask(reportId,assignerId,assignedId);
        return "creation of task done with success " ;
    }

    @PatchMapping("tasks/{taskId}/modify-driver")
    public String UpdateAssinedDriver(@PathVariable("taskId") int taskId ,@RequestParam(name="assignedid") int assignedid ){

        dashboardserviceimp.changeassinedDriver(taskId,assignedid);

        return "update of driver task done with success " ;
    }


    @GetMapping("/citizens")
    public List<normalUser> getAllCitizens(){

        return dashboardserviceimp.getAllCitizens() ;
    }


}
