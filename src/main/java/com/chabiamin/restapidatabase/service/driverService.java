package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.driver;

import java.util.List;
import java.util.Optional;

public interface driverService {

    public List<driver> getAllDrivers();

    public Optional<driver> getDriverById(int id);

    public void createDriver(driver driverObj);


}
