package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.exception.DriverException.sameDriverException;
import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class dashboardServiceImp implements dashboardService{

    driverServiceImp driverserviceImp ;
    reportsServiceImp reportsserviceImp ;
    systemUserRepository systemuserrepository ;
    normalUserRepository normalUserRepository ;
    cleanTaskRepository cleantaskrepository ;


    /**
     * now mazal
     *
     *
     * task repository
     *
     */

    @Autowired
    public dashboardServiceImp( driverServiceImp driverserviceImp ,
                                reportsServiceImp reportsserviceImp ,
                                cleanTaskRepository cleantaskrepository,
                                normalUserRepository normalUserRepository,
                                systemUserRepository systemuserrepository
) {

        this.driverserviceImp=driverserviceImp;
        this.reportsserviceImp=reportsserviceImp;
        this.cleantaskrepository = cleantaskrepository ;
        this.normalUserRepository=normalUserRepository;
        this.systemuserrepository=systemuserrepository;
    }





    @Override

    public String Create_Task(int reportid , int systemUserId , int driverId) {
            Report report = reportsserviceImp.get_Report(reportid)
                    .orElseThrow(() -> new EntityNotFoundException("report not found with id: " + reportid));

            // a case that won't happen in real time
            systemUser systemuser = systemuserrepository.findById(systemUserId)
                    .orElseThrow(() -> new EntityNotFoundException("systemUser did not found with id: "+ systemUserId));

            driver driverr = driverserviceImp.get_Driver_ById(driverId)
                    .orElseThrow(() -> new EntityNotFoundException("Driver not found with id: "+ driverId));

            cleanTask cleantask = new cleanTask(report,systemuser,driverr);
            cleantask.setCreatedAt(java.time.LocalDateTime.now());
            cleantask.setStatus("not done");
            cleantaskrepository.save(cleantask);

           return  "task created with success";
    }
    @Override

    public String change_assigned_Driver(int taskId , int newDriverId){

        cleanTask cleantask = cleantaskrepository.findById(taskId).orElseThrow(
                ()-> new TaskNotFoundException("the Task you are trying to find is not found with id "+taskId)
        );

        Optional<driver> driver1 = Optional.ofNullable(driverserviceImp.get_Driver_ById(newDriverId).
                orElseThrow(() -> new EntityNotFoundException("Driver new Replacement is not found with id " + newDriverId)));;

       if(driver1.get().getId()==cleantask.getAssigneddriver().getId()){
                throw new sameDriverException("new Driver is the same Driver with the id "+ newDriverId);
       }


        cleantask.setAssigneddriver(driver1.get());

        cleantaskrepository.save(cleantask);


        return "update done with success the Task id of  "+taskId + " is assigned to the driver with id  "+newDriverId ;


    }

    @Override
    public List<normalUser> get_All_Citizens() {
        return normalUserRepository.findAll();
    }




    @Override
    public List<systemUser> get_All_SystemUsers(){

            System.out.println("system retrieve all ");

           return systemuserrepository.findAll();
    }



}
