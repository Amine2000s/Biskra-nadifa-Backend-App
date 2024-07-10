package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.exception.DriverException.DriverNotFoundException;
import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportNotFoundException;
import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("/dashboard")
public class dashboardApi {


    reportsServiceImp reportsServiceImp;


    dashboardServiceImp dashboardserviceimp;
    cleanTaskServiceImp cleantaskserviceImp ;
    suggestionServiceImp suggestionserviceimp;
    driverServiceImp driverserviceimp;

    com.chabiamin.restapidatabase.service.modernBinServiceImp modernbinServiceimp;

    trashCollectionScheduleServiceImp trashcollectionscheduleserviceImp ;

@Autowired
    public dashboardApi(reportsServiceImp reportsServiceImp1,
                        dashboardServiceImp dashboardserviceimp,
                        modernBinServiceImp modernBinServiceImp,
                        trashCollectionScheduleServiceImp trashcollectionscheduleserviceImp,
                        driverServiceImp driverserviceimp,
                        suggestionServiceImp suggestionserviceimp,
                        cleanTaskServiceImp cleantaskserviceImp) {

        this.reportsServiceImp = reportsServiceImp1;
        this.dashboardserviceimp = dashboardserviceimp ;
        this.modernbinServiceimp = modernBinServiceImp ;
        this.trashcollectionscheduleserviceImp = trashcollectionscheduleserviceImp;
        this.driverserviceimp = driverserviceimp ;
        this.suggestionserviceimp = suggestionserviceimp;
        this.cleantaskserviceImp = cleantaskserviceImp ;
    }

    @GetMapping("/drivers")
    public List<driver> getAllDrivers(){


        return driverserviceimp.getAllDrivers() ;
    }

    @PostMapping("driver/create")
    public String createDriver(@RequestBody driver driverobj){

                driverserviceimp.createDriver(driverobj);

        return "driver created with succes" ;
    }
    @GetMapping("/reports")
    public List<Report> getAllReports(){

        return  reportsServiceImp.getAllReports();
    }

    @GetMapping("/reports/{reportId}")
    public Optional<Report> getReportByid(@PathVariable int reportId){

       if(reportsServiceImp.getReport(reportId)==null){

           throw new ReportNotFoundException("Report Not found");

       }else{
           return reportsServiceImp.getReport(reportId);
       }
    }


    @DeleteMapping("/report/{reportId}")
    public String deleteReportByid(@PathVariable int reportId){

        reportsServiceImp.deleteReport(reportId);


        return "Delete OPeration DOne with sucees " ;
    }

    @GetMapping("/suggestions")
    public List<sugesstion> getAllSugesstion(){

        return suggestionserviceimp.getAllSugesstions() ;
    }

    @GetMapping("/tasks")
    public List<cleanTask> getAllCleaningTasks(){

        return cleantaskserviceImp.getAllTasks() ;
    }

    @GetMapping("/tasks/{taskId}")
    public cleanTask getTasksbyID(@PathVariable int taskId){

        return cleantaskserviceImp.getTaskbyId(taskId) ;

    }
   // http://localhost:8083/dashboard/tasks/?reportId=2&assignerId=3&assignedId=4



    @PutMapping("/assigntask/{reportId}/{assignerId}/{assignedId}")
    public ResponseEntity<Object> createTask(@PathVariable("reportId") int reportId , @PathVariable("assignerId") int assignerId, @PathVariable("assignedId") int assignedId ){


        if(driverserviceimp.getDriverById(assignedId)==null){
            throw  new DriverNotFoundException("Driver Not Found ") ;
        }
        if(reportsServiceImp.getReport(reportId)==null){
           throw  new ReportNotFoundException("Report not Found");
        }
        dashboardserviceimp.CreateTask(reportId,assignerId,assignedId);

        return new ResponseEntity<>(new Object(),HttpStatus.CREATED) ;
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

        return modernbinServiceimp.getAllBin() ;
    }

    @PostMapping("/bins/create")
    public void createBin(@RequestBody modernBin bin){

        modernbinServiceimp.addBin(bin);


    }

    @DeleteMapping("bins/bin/{binid}")
    public void deleteBinbyID(@PathVariable int binid){

        modernbinServiceimp.deleteBin(binid);



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
