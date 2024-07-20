package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.cleanTask;
import com.chabiamin.restapidatabase.service.cleanTaskServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(driverApi.class)
class driverApiTest {


    @MockBean
    com.chabiamin.restapidatabase.service.cleanTaskServiceImp cleanTaskServiceImp;

    @Autowired
    private MockMvc mockMvc ;

    cleanTask task1 , task2 ;
    List<cleanTask> cleanTasklist ;

    @BeforeEach
    void setUp() {

        task1 = cleanTask.builder()
                .id(1)
                .status("not done")
                .build();
    }

    @AfterEach
    void tearDown() {

        task1 = null ;
        task2=null;
    }

    @Test
    void getTasksByDriverId() throws Exception {

        task1 = cleanTask.builder()
                .id(1)
                .status("not done")
                .build();

        task2 = cleanTask.builder()
                .id(2)
                .status("not done")
                .build();

        cleanTasklist = new ArrayList<>();
        cleanTasklist.add(task1);
        cleanTasklist.add(task2);


        when(cleanTaskServiceImp.getTasksbyDriverId(1)).thenReturn( cleanTasklist);

        ResultActions result = mockMvc.perform(get("/drivers/{driverId}/tasks",1))
                .andDo(print());

        result.andExpect(status().is2xxSuccessful());

    }

    @Test
    void updateTaskbyID() throws Exception {


        when(cleanTaskServiceImp.updateTaskStatus(1,"Done"))
                .thenReturn("Task Status Updated Successfully");
        this.mockMvc.perform(patch("/drivers/{driverId}/{taskId}/update-task-status",1,1)
                        .param("status","DOOONE"))
                        .andDo(print()).andExpect(status().isAccepted());
    }




}