package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.driver;
import com.chabiamin.restapidatabase.repository.driverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class driverServiceImp implements driverService{

    driverRepository driverrepository ;

    @Override
    public List<driver> get_AllDrivers() {


        return  driverrepository.findAll();
    }
    @Override
    public Optional<driver> get_Driver_ById(int driverId){

        if(driverrepository.findById(driverId).isEmpty()){
            return  null;
        }else{
            return driverrepository.findById(driverId);
        }


    }
    @Override
    public void createDriver(driver driverObj){

        driverrepository.save(driverObj);
    }

}
