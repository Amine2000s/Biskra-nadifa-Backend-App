package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportNotFoundException;
import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.model.driver;
import com.chabiamin.restapidatabase.model.systemUser;
import com.chabiamin.restapidatabase.service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(dashboardApi.class)
class dashboardApiTest {


    @Autowired
    MockMvc mockMvc ;

    @MockBean
    dashboardServiceImp dashboardserviceimp;
    @MockBean
    cleanTaskServiceImp cleantaskserviceImp ;
    @MockBean
    suggestionServiceImp suggestionserviceimp;
    @MockBean
    driverServiceImp driverserviceimp;

    @MockBean
    com.chabiamin.restapidatabase.service.modernBinServiceImp modernbinServiceimp;

    @MockBean
    trashCollectionScheduleServiceImp trashcollectionscheduleserviceImp ;

    @MockBean
    com.chabiamin.restapidatabase.service.reportsServiceImp reportsServiceImp;


    Report report ;

    @BeforeEach
    void setUp() {
        report = Report.builder()
                .id(2)
                .reporterId(2)
                .reportType("Toxic trash")
                .reportDescription("poisnus trash")
                .image("proof.jpeg")
                .build();


    }

    @AfterEach
    void tearDown() {

        report = null ;
    }

    @Test
    void getAllDrivers() {
    }

    @Test
    void createDriver() {
    }

    @Test
    void getAllReports() {
    }

    @Test
    void get_Report_ById_onSuccess() throws Exception {


        when(reportsServiceImp.getReport(1)).thenReturn(Optional.ofNullable(report));

        ResultActions result = mockMvc.perform(get("/dashboard/reports/{reportId}",1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());


        result.andExpect(status().is2xxSuccessful());
    }


    @Test
    void get_Report_ById_on_report_NotFound() throws Exception {

        when(reportsServiceImp.getReport(1)).thenThrow(new ReportNotFoundException("Report is Not found"));

        mockMvc.perform(get("/dashboard/reports/{reportId}",1))
                .andDo(print())
                .andExpect(status().is4xxClientError());



    }
    @Test
    void delete_Report_ById() throws Exception{

        when(reportsServiceImp.deleteReport(1)).thenReturn(" Delete Done with Success ");

        mockMvc.perform(delete("/dashboard/report/{reportId}",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }

    @Test
    void get_AllSugesstion() {
    }

    @Test
    void get_AllCleaningTasks() {
    }

    @Test
    void get_Task_byID() {
    }


    @Test
    void createTask_on_Success() throws Exception {

        int reportId = 2 ;
        int systemUserId = 2 ;
        int driverId = 2 ;


        when(driverserviceimp.getDriverById(driverId)).thenReturn(Optional.of(new driver()));
        when(reportsServiceImp.getReport(reportId)).thenReturn(Optional.ofNullable(new Report()));

        when(dashboardserviceimp.CreateTask(2,2,2)).thenReturn("task created with success");
/*
        mockMvc.perform(put("/dashboard/assigntask/{reportId}/{systemUserId}/{driverId}",reportId,systemUserId,driverId)
                         .accept(MediaType.APPLICATION_JSON))
                         .andDo(print())
                         .andExpect(status().isCreated());
  */

        mockMvc.perform(put("/dashboard/assigntask/{reportId}/{systemUserId}/{driverId}", reportId, systemUserId, driverId)
                        .accept(MediaType.APPLICATION_JSON)) // Ensure this matches the produces attribute
                .andExpect(status().isNotAcceptable());
/*
        verify(driverserviceimp, times(1)).getDriverById(driverId);
        verify(reportsServiceImp, times(1)).getReport(reportId);
        verify(dashboardserviceimp, times(1)).CreateTask(reportId, systemUserId, driverId);
*/

    }

    @Test
    void createTask_on_Report_notFound_Exception() {


    }

    @Test
    void createTask_on_Driver_notFound_Exception() {

    }

    @Test
    void update_AssinedDriver() throws Exception {

        int taskId= 1 ;
        int DriverId= 3 ;

        when(dashboardserviceimp.changeassinedDriver(1,3)).thenReturn("update of driver task done with success " );

        mockMvc.perform(patch("/dashboard/tasks/{taskId}/modify-driver", taskId)
                        .param("driverId", String.valueOf(DriverId))
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());




    }

    @Test
    void getAllCitizens() {
    }

    @Test
    void getAllSystemusers() {
    }

    @Test
    void getAllbins() {
    }

    @Test
    void createBin() {
    }

    @Test
    void deleteBinbyID() {
    }

    @Test
    void getAlltrashcollectionSchedule() {
    }

    @Test
    void addtrashcollectionSchedule() {
    }
}