package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.driver;

import java.util.List;
import java.util.Optional;

public interface driverService {

    public List<driver> get_AllDrivers();

    public Optional<driver> get_Driver_ById(int id);

    public void createDriver(driver driverObj);


}
