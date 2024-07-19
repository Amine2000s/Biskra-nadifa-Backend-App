package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.*;
import com.chabiamin.restapidatabase.repository.normalUserRepository;
import com.chabiamin.restapidatabase.repository.reportsRepository;
import com.chabiamin.restapidatabase.service.modernBinServiceImp;
import com.chabiamin.restapidatabase.service.reportsServiceImp;
import com.chabiamin.restapidatabase.service.suggestionServiceImp;
import com.chabiamin.restapidatabase.service.trashCollectionScheduleServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;


import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import javax.net.ssl.SSLEngineResult;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(citizenAPi.class)
class citizenAPiTest {


    @Autowired
   private MockMvc mockMvc;


    @MockBean
    suggestionServiceImp suggestionServiceimp ;

    @MockBean
    com.chabiamin.restapidatabase.service.reportsServiceImp reportsServiceImp;

    @MockBean
    reportsRepository reportsrepository ;

    @MockBean
    normalUserRepository normaluserRepository ;

    @MockBean
    com.chabiamin.restapidatabase.service.modernBinServiceImp modernBinServiceImp;

    @MockBean
    trashCollectionScheduleServiceImp trashcollectionScheduleservice ;

     Report report1 ;

     byte[] imagedata = Base64.getDecoder().decode("SGVsbG8gd29ybGQ=");


    modernBin modernbin1 ;
     modernBin modernbin2 ;

     sugesstion suggestion ;
     List<modernBin> modernBinList  ;


     trashCollectionSchedule day1 ;
     trashCollectionSchedule day2 ;

     List<trashCollectionSchedule> listofSchedule ;



 @Test
    void createsuggestionTest_onSuccess() throws Exception {



     String SuggestionJson = "{"
             + "\"suggestionTitle\": \"Plastic Alternatives (suggestion testing )\","
             + "\"suggestionDescription\": \"السلام عليكم\","
             + "\"createdAt\": \"2022-06-11 00:03:49.000000\""
             + "}";


     when(suggestionServiceimp.createSugesstion(1,suggestion))
             .thenReturn("Suggestion created With success");

     ResultActions result = mockMvc.perform(post("/citizens/suggestion/{citizenID}",1)
             .contentType(MediaType.APPLICATION_JSON)
             .content(SuggestionJson))
             .andDo(print());

     result.andExpect(status().isCreated());


    }

    @Test
    void uploadReporttest_onSucess() throws Exception {

        report1 = Report.builder()
                .id(2)
                .reporterId(2)
                .reportType("Toxic trash")
                .reportDescription("poisnus trash")
                .image("proof.jpeg")
                .imagedata(imagedata)
                .build();

        String  reportJson = new Gson().toJson(report1);


       when(reportsServiceImp.addReport(report1)).thenReturn("added with succes ");
        ResultActions result = mockMvc.perform(post("/citizens/Report",1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reportJson))
                .andDo(print());

        result.andExpect(status().isCreated());


    }


   @Test
   void uploadReporttest_onImageDataException() throws Exception {

       report1 = Report.builder()
               .id(2)
               .reporterId(2)
               .reportType("Toxic trash")
               .reportDescription("poisnus trash")
               .image("proof.jpeg")
               .imagedata(null)
               .build();

       String  reportJson = new Gson().toJson(report1);


           when(reportsServiceImp.addReport(report1)).thenReturn("added with succes ");
       ResultActions result = mockMvc.perform(post("/citizens/Report",1)
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(reportJson))
               .andDo(print());

       result.andExpect(status().is4xxClientError());

   }
    @Test
    void getAllbins() throws Exception {

            modernbin1 = modernBin.builder()
                    .id(1)
                    .longtitude(11.5)
                    .latitude(33.1)
                    .build();

        modernbin2 = modernBin.builder()
                .id(2)
                .longtitude(21.5)
                .latitude(4.1)
                .build();

        modernBinList = new ArrayList<>();
        modernBinList.add(modernbin1);
        modernBinList.add(modernbin2);

        when(modernBinServiceImp.getAllBin()).thenReturn(modernBinList);

        ResultActions result = mockMvc.perform(get("/citizens/bins",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        result.andExpect(status().is2xxSuccessful());

    }

    @Test
    void getAlltrashcollectionSchedule() throws Exception {

        day1 = trashCollectionSchedule.builder()
                .id(1)
                .day("monday")
                .availability("availlable")
                .timeSlot("02:00-05:00")
                .build();

        day2 = trashCollectionSchedule.builder()
                .id(3)
                .day("sunday")
                .availability("availlable")
                .timeSlot("02:00-05:00")
                .build();

        listofSchedule = new ArrayList<>();
        listofSchedule.add(day1);
        listofSchedule.add(day2);


        when(trashcollectionScheduleservice.getAllSchedule()).thenReturn(listofSchedule);
        ResultActions result = mockMvc.perform(get("/citizens/trashcollectionSchedule",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        result.andExpect(status().is2xxSuccessful());


    }
}