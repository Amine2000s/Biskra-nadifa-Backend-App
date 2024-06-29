package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportNotFoundException;
import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.service.dashboardServiceImp;
import com.chabiamin.restapidatabase.service.modernBinServiceImp;
import com.chabiamin.restapidatabase.service.reportServiceImp;
import com.chabiamin.restapidatabase.service.trashCollectionScheduleServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("/dashboard")
public class dashboardApi {


    reportServiceImp reportServiceImp ;


    dashboardServiceImp dashboardserviceimp;


    com.chabiamin.restapidatabase.service.modernBinServiceImp modernBinServiceImp;

    trashCollectionScheduleServiceImp trashcollectionscheduleserviceImp ;


    public dashboardApi(reportServiceImp reportServiceImp1, dashboardServiceImp dashboardserviceimp,
                        modernBinServiceImp modernBinServiceImp
    ,trashCollectionScheduleServiceImp trashcollectionscheduleserviceImp) {

        this.reportServiceImp = reportServiceImp1 ;
        this.dashboardserviceimp = dashboardserviceimp ;
        this.modernBinServiceImp = modernBinServiceImp ;
        this.trashcollectionscheduleserviceImp = trashcollectionscheduleserviceImp;
    }

    @GetMapping("/drivers")
    public List<driver> getAllDrivers(){


        return dashboardserviceimp.getAllDrivers() ;
    }

    @PostMapping("driver/create")
    public String createDriver(@RequestBody driver driverobj){

                dashboardserviceimp.createDriver(driverobj);

        return "driver created with succes" ;
    }
    @GetMapping("/reports")
    public List<Report> getAllReports(){

        return  reportServiceImp.getAllReports();
    }

    @GetMapping("/reports/{reportId}")
    public Optional<Report> getReportByid(@PathVariable int reportId){

       if(reportServiceImp.getReport(reportId)==null){

           throw new ReportNotFoundException("Report Not found");

       }else{
           return reportServiceImp.getReport(reportId);
       }
    }


    @DeleteMapping("/report/{reportId}")
    public String deleteReportByid(@PathVariable int reportId){

        reportServiceImp.deleteReport(reportId);

        System.out.println("Delete OPeration DOne with sucees ");

        return "Delete OPeration DOne with sucees " ;
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
    public Optional<cleanTask> getTasksbyID(@PathVariable int taskId){

        if(dashboardserviceimp.getTaskbyID(taskId)==null){
            throw new TaskNotFoundException("Task not found ");
        }else{
            return dashboardserviceimp.getTaskbyID(taskId) ;

        }
    }
   // http://localhost:8083/dashboard/tasks/?reportId=2&assignerId=3&assignedId=4



    @PutMapping("/assigntask/{reportId}/{assignerId}/{assignedId}")
    public String createTask(@PathVariable("reportId") int reportId , @PathVariable("assignerId") int assignerId,@PathVariable("assignedId") int assignedId ){

        dashboardserviceimp.CreateTask(reportId,assignerId,assignedId);
        System.out.println("helllo");
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

    @GetMapping("/systemusers")
    public List<systemUser> getAllSystemusers(){

        return dashboardserviceimp.getAllSystemUsers() ;
    }


    @GetMapping("/bins")
    public List<modernBin> getAllbins(){

        return dashboardserviceimp.getAllBin() ;
    }

    @PostMapping("/bins/create")
    public void createBin(@RequestBody modernBin bin){

        dashboardserviceimp.addBin(bin);


    }

    @DeleteMapping("bins/bin/{binid}")
    public void deleteBinbyID(@PathVariable int binid){

        dashboardserviceimp.deleteBin(binid);



    }

    @GetMapping("/trashcollectionSchedule")
    public List<trashCollectionSchedule> getAlltrashcollectionSchedule(){

        return trashcollectionscheduleserviceImp.getAllSchedule() ;
    }

    @PostMapping("/trashcollectionSchedule/create")
    public void addtrashcollectionSchedule(@RequestBody trashCollectionSchedule trashcollection){

        trashcollectionscheduleserviceImp.addSchedule(trashcollection);

        System.out.println("creation of timestamp");
    }

}
