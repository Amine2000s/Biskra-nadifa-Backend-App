package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.exception.DriverException.DriverNotFoundException;
import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportNotFoundException;
import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.service.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Operation(description = "Returns a List of All Drivers ")
    @GetMapping("/drivers")
    public List<driver> get_All_Drivers(){


        return driverserviceimp.get_AllDrivers() ;
    }
    @Operation(description = "Adds a driver  ")

    @PostMapping("driver/create")
    public String create_Driver(@RequestBody driver driverobj){

                driverserviceimp.createDriver(driverobj);

        return "driver created with succes" ;
    }
    @GetMapping("/reports")
    public List<Report> get_All_Reports(){

        return  reportsServiceImp.get_AllReports();
    }
    @Operation(description = "get Report as per the id")

    @GetMapping("/reports/{reportId}")
    public Optional<Report> get_Report_ById(@PathVariable int reportId){

       if(reportsServiceImp.get_Report(reportId)==null){

           throw new ReportNotFoundException("Report Not found");

       }else{
           return reportsServiceImp.get_Report(reportId);
       }
    }

    @Operation(description = "Delete Report as per the id")

    @DeleteMapping("/report/{reportId}")
    public String delete_Report_ById(@PathVariable int reportId){

        reportsServiceImp.delete_Report(reportId);


        return "Delete Operation Done with success " ;
    }


    @Operation(description = "Returns a List of Suggestions")

    @GetMapping("/suggestions")
    public List<suggestion> get_All_Sugesstion(){

        return suggestionserviceimp.get_All_Sugesstions() ;
    }


    @Operation(description = "Returns a List of tasks")

    @GetMapping("/tasks")
    public List<cleanTask> get_All_CleaningTasks(){

        return cleantaskserviceImp.get_AllTasks() ;
    }

    @GetMapping("/tasks/{taskId}")
    public cleanTask get_Tasks_byID(@PathVariable int taskId){

        return cleantaskserviceImp.get_Task_byId(taskId) ;

    }
   // http://localhost:8083/dashboard/tasks/?reportId=2&assignerId=3&assignedId=4


    @Operation(description = "Creates a Task")
    @PutMapping(value="/assigntask/{reportId}/{systemUserId}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create_Task(@PathVariable("reportId") int reportId , @PathVariable("systemUserId") int assignerId, @PathVariable("driverId") int assignedId ){


        if(driverserviceimp.get_Driver_ById(assignedId)==null){
            throw  new DriverNotFoundException("Driver Not Found ") ;
        }
        if(reportsServiceImp.get_Report(reportId)==null){
           throw  new ReportNotFoundException("Report not Found");
        }
        dashboardserviceimp.Create_Task(reportId,assignerId,assignedId);

        return new ResponseEntity<>(new Object(),HttpStatus.CREATED) ;
    }

    @Operation(description = "modify the Responsible Driver of the Cleaning Task")

    @PatchMapping("tasks/{taskId}/modify-driver")
    public String Update_Assigned_Driver(@PathVariable("taskId") int taskId ,@RequestParam(name="driverId") int driverId ){

        dashboardserviceimp.change_assigned_Driver(taskId,driverId);

        return "update of driver task done with success " ;
    }


    @GetMapping("/citizens")
    public List<normalUser> get_All_Citizens(){

        return dashboardserviceimp.get_All_Citizens() ;
    }

    @GetMapping("/systemusers")
    public List<systemUser> get_All_Systemusers(){

        return dashboardserviceimp.get_All_SystemUsers() ;
    }


    @GetMapping("/bins")
    public List<modernBin> get_All_bins(){

        return modernbinServiceimp.getAllBin() ;
    }

    @PostMapping("/bins/create")
    public void create_Bin(@RequestBody modernBin bin){

        modernbinServiceimp.addBin(bin);


    }

    @DeleteMapping("bins/bin/{binid}")
    public void delete_Bin_byID(@PathVariable int binid){

        modernbinServiceimp.deleteBin(binid);



    }

    @GetMapping("/trashcollectionSchedule")
    public List<trashCollectionSchedule> get_All_Trash_Collection_Schedule(){

        return trashcollectionscheduleserviceImp.getAllSchedule() ;
    }

    @PostMapping("/trashcollectionSchedule/create")
    public void add_Trash_Collection_Schedule(@RequestBody trashCollectionSchedule trashcollection){

        trashcollectionscheduleserviceImp.addSchedule(trashcollection);

        System.out.println("creation of timestamp");
    }

}
