package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.exception.DriverException.sameDriverException;
import com.chabiamin.restapidatabase.exception.TaskExceptions.TaskNotFoundException;
import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.model.driver;
import com.chabiamin.restapidatabase.model.systemUser;
import com.chabiamin.restapidatabase.repository.cleanTaskRepository;
import com.chabiamin.restapidatabase.repository.systemUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class dashboardServiceImpTest {



    // we need to mock repository layer


    @Mock
    private driverServiceImp driverserviceImp ;
    @Mock

    private reportsServiceImp reportsserviceImp ;
    @Mock

    private systemUserRepository systemuserrepository ;
    @Mock

    private com.chabiamin.restapidatabase.repository.normalUserRepository normalUserRepository ;
    @Mock

    private cleanTaskRepository cleantaskrepository ;
    @Mock
    private dashboardServiceImp dashboardserviceImp ;

    AutoCloseable autoCloseable ;

    private Report report ;
    private driver Driver ;
    private systemUser systemuser ;
    private cleanTask cleantask ;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);

        dashboardserviceImp = new dashboardServiceImp(driverserviceImp,
                reportsserviceImp ,
                 cleantaskrepository,
                 normalUserRepository,
                 systemuserrepository);


        report = Report.builder().id(1)
                .reporterId(5)
                .reportType("Toxic trash")
                .reportDescription("there is too much toxic trash ").build();

        systemuser = systemUser.builder().id(2)
                .name("mohammed")
                .surName("Ali")
                .build();

        Driver = driver.builder().id(3)
                .name("Ahmed")
                .surName("amin")
                .build();


    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void createTask_Onsucess() {

        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(reportsServiceImp.class);
        mock(systemUserRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);

        when(cleantaskrepository.save(cleantask)).thenReturn(cleantask);
        when(reportsserviceImp.get_Report(report.getId())).thenReturn(Optional.ofNullable(report));
        when(systemuserrepository.findById(systemuser.getId())).thenReturn(Optional.ofNullable(systemuser));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(Driver));

        assertThat(dashboardserviceImp.Create_Task(report.getId(), systemuser.getId(), Driver.getId())).isEqualTo("task created with succes");






    }

    @Test
    void createTask_Whendriver_notFound() {

        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(reportsServiceImp.class);
        mock(systemUserRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);

        when(cleantaskrepository.save(cleantask)).thenReturn(cleantask);
        when(reportsserviceImp.get_Report(report.getId())).thenReturn(Optional.ofNullable(report));
        when(systemuserrepository.findById(systemuser.getId())).thenReturn(Optional.ofNullable(systemuser));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(null));

        EntityNotFoundException EntityNotFoundException = assertThrows(EntityNotFoundException.class , ()->
                dashboardserviceImp.Create_Task(report.getId(),systemuser.getId(),Driver.getId()));

        assertEquals("Driver not found with id: "+ Driver.getId(),EntityNotFoundException.getMessage());





    }

    @Test
    void createTask_Onreport_notFound() {

        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(reportsServiceImp.class);
        mock(systemUserRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);

        when(cleantaskrepository.save(cleantask)).thenReturn(cleantask);
        when(reportsserviceImp.get_Report(report.getId())).thenReturn(Optional.ofNullable(null));
        when(systemuserrepository.findById(systemuser.getId())).thenReturn(Optional.ofNullable(systemuser));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(Driver));

        EntityNotFoundException EntityNotFoundException = assertThrows(EntityNotFoundException.class , ()->
                dashboardserviceImp.Create_Task(report.getId(),systemuser.getId(),Driver.getId()));

        assertEquals("report not found with id: " + report.getId(),EntityNotFoundException.getMessage());






    }

    @Test
    void createTask_WhensystemUser_notFound() {

        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(reportsServiceImp.class);
        mock(systemUserRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);

        when(cleantaskrepository.save(cleantask)).thenReturn(cleantask);
        when(reportsserviceImp.get_Report(report.getId())).thenReturn(Optional.ofNullable(report));
        when(systemuserrepository.findById(systemuser.getId())).thenReturn(Optional.ofNullable(null));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(Driver));

        EntityNotFoundException EntityNotFoundException = assertThrows(EntityNotFoundException.class , ()->
                dashboardserviceImp.Create_Task(report.getId(),systemuser.getId(),Driver.getId()));

        assertEquals("systemUser did not found with id: "+ systemuser.getId(),EntityNotFoundException.getMessage());

    }


    @Test
    void changeassinedDriver_WhenSuccess() {

        mock(cleanTask.class);
        mock(cleanTaskRepository.class);

        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);

        driver Driver1 = driver.builder().id(4)
                .name("mahmoued")
                .surName("sabri")
                .build();

        when(cleantaskrepository.findById(cleantask.getId())).thenReturn(Optional.ofNullable(cleantask));
        when(driverserviceImp.get_Driver_ById(Driver1.getId())).thenReturn(Optional.ofNullable(Driver1));


        assertThat(dashboardserviceImp.change_assigned_Driver(cleantask.getId(),Driver1.getId())).
                isEqualTo("update done with success the Task id of  "+cleantask.getId() + " is assigned to the driver with id  "+Driver1.getId());


    }

    @Test
    void changeassinedDriver_WhenTask_isNotFound() {

        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);


        when(cleantaskrepository.findById(cleantask.getId())).thenReturn(Optional.ofNullable(null));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(Driver));

        Exception exception = assertThrows(TaskNotFoundException.class , ()->
                dashboardserviceImp.change_assigned_Driver(cleantask.getId(),Driver.getId()));
        assertEquals("the Task you are trying to find is not found with id "
                +cleantask.getId(),exception.getMessage());

    }


    @Test
    void changeassinedDriver_WhenDriver_isNotFound() {
        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);


        when(cleantaskrepository.findById(cleantask.getId())).thenReturn(Optional.ofNullable(cleantask));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(EntityNotFoundException.class , ()->
                dashboardserviceImp.change_assigned_Driver(cleantask.getId(),Driver.getId()));
        assertEquals("Driver new Replacement is not found with id " + Driver.getId(),exception.getMessage());


    }

    @Test
    void changeassinedDriver_When_sameDriver() {
        mock(cleanTask.class);
        mock(cleanTaskRepository.class);
        mock(driverServiceImp.class);

        cleantask = new cleanTask(report,systemuser,Driver);


        when(cleantaskrepository.findById(cleantask.getId())).thenReturn(Optional.ofNullable(cleantask));
        when(driverserviceImp.get_Driver_ById(Driver.getId())).thenReturn(Optional.ofNullable(Driver));

        Exception exception = assertThrows(sameDriverException.class , ()->
                dashboardserviceImp.change_assigned_Driver(cleantask.getId(),Driver.getId()));
        assertEquals("new Driver is the same Driver with the id "+ Driver.getId(),exception.getMessage());


    }

}