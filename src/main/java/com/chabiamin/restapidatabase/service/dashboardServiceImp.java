package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class dashboardServiceImp implements dashboardService{

    driverRepository driverrepository ;
    reportsRepository reportsrepository ;

    systemUserRepository systemuserrepository ;
    sugesstionsRepository sugesstionsrepository;
    normalUserRepository normalUserRepository ;
    cleanTaskRepository cleantaskrepository ;

    modernBinServiceImp modernbinserviceImp ;

    /**
     * now mazal
     *
     *
     * task repository
     *
     */

    @Autowired
    public dashboardServiceImp( driverRepository driverrepository , reportsRepository reportsrepository ,sugesstionsRepository sugesstionsrepository ,
                                cleanTaskRepository cleantaskrepository,
                                normalUserRepository normalUserRepository,
                                systemUserRepository systemuserrepository,
                                modernBinServiceImp modernbinserviceImp
) {

        this.driverrepository=driverrepository;
        this.reportsrepository=reportsrepository;
        this.sugesstionsrepository = sugesstionsrepository;
        this.cleantaskrepository = cleantaskrepository ;
        this.normalUserRepository=normalUserRepository;
        this.systemuserrepository=systemuserrepository;
        this.modernbinserviceImp = modernbinserviceImp;
    }

    @Override
    public List<driver> getAllDrivers() {


        return  driverrepository.findAll();
    }

    @Override
    public List<Report> getAllReports() {
        return reportsrepository.findAll();

    }

    @Override
    public List<sugesstion> getAllSugesstions() {

        return sugesstionsrepository.findAll();
    }


    public cleanTask getTaskbyID(int id) {

        return cleantaskrepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("clean task not found with id " + id ));

    }

    public void CreateTask(int reportid , int assignerid , int assignedid) {
            Report report = reportsrepository.findById(reportid)
                    .orElseThrow(() -> new EntityNotFoundException("report not found with id: " + reportid));

            systemUser systemuser = systemuserrepository.findById(assignerid)
                    .orElseThrow(() -> new EntityNotFoundException("assigner did not found with id "+ assignedid));

            driver driverr = driverrepository.findById(assignedid)
                    .orElseThrow(() -> new EntityNotFoundException("Driver not found with id "+ assignedid));

            cleanTask cleantask = new cleanTask();
            cleantask.setReport(report);
            cleantask.setAssingerSystemUser(systemuser);
            cleantask.setAssigneddriver(driverr);
            cleantask.setCreatedAt(java.time.LocalDateTime.now());

            cleantaskrepository.save(cleantask);

            System.out.println("done with succes ");
    }

    public String changeassinedDriver(int id , int newassignedid){

        Optional<cleanTask> cleantask = cleantaskrepository.findById(id);

        Optional<driver> driver1 = Optional.ofNullable(driverrepository.findById(newassignedid).
                orElseThrow(() -> new EntityNotFoundException("Driver replacemnt  not found with id " + newassignedid)));;

        cleantask.get().setAssigneddriver(driver1.get());

        cleantaskrepository.save(cleantask.get());


        return "update done with success new id is "+id + "or "+newassignedid ;


    }

    @Override
    public List<normalUser> getAllCitizens() {
        return normalUserRepository.findAll();
    }

    @Override
    public List<cleanTask> getAllTaskCleaning() {
        return cleantaskrepository.findAll();
    }


    public void createDriver(driver driverobj){
        driverrepository.save(driverobj);
    }

    public List<systemUser> getAllSystemUsers(){

            System.out.println("system retrieve all ");

           return systemuserrepository.findAll();
    }

    public List<modernBin> getAllBin() {



        return modernbinserviceImp.getAllBin() ;
    }

    public void addBin(modernBin moderbin) {

        modernbinserviceImp.addBin(moderbin);


    }

    public void deleteBin(int id) {

        modernbinserviceImp.deleteBin(id);



    }




}
