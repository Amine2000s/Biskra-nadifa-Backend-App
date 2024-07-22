package com.chabiamin.restapidatabase.controller;


import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportImageNotUploadedException;
import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.model.modernBin;
import com.chabiamin.restapidatabase.model.suggestion;
import com.chabiamin.restapidatabase.model.trashCollectionSchedule;
import com.chabiamin.restapidatabase.repository.reportsRepository;
import com.chabiamin.restapidatabase.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/citizens")
public class citizenAPi {

    suggestionServiceImp suggestionService ;
    reportsServiceImp reportsServiceImp;

    reportsRepository reportsrepository ;

    modernBinServiceImp modernBinServiceImp;


    trashCollectionScheduleServiceImp trashcollectionScheduleservice ;




    @Autowired
    public citizenAPi ( reportsServiceImp reportsServiceImp1,
                        reportsRepository reportsrepository,
                        suggestionServiceImp suggestionservice,
                        modernBinServiceImp modernBinServiceImp,
                        trashCollectionScheduleServiceImp trashcollectionScheduleservice ){

        this.reportsServiceImp = reportsServiceImp1;
        this.reportsrepository = reportsrepository;
        this.suggestionService = suggestionservice ;
        this.modernBinServiceImp = modernBinServiceImp;
        this.trashcollectionScheduleservice = trashcollectionScheduleservice;


    }




    @PostMapping("/suggestion/{citizenId}")
    public ResponseEntity<String> create_suggestion(@PathVariable int citizenId , @RequestBody suggestion suggestioninput){

        suggestionService.create_Sugesstion(citizenId,suggestioninput);

        return new ResponseEntity<>("Suggestion saved succesffully ", HttpStatus.CREATED) ;

    }


    // The Client Send a Base64 String which represents the Image report

    @PostMapping(value = "/Report")
    public ResponseEntity<String> upload_Report(@RequestBody Report report) throws IOException {

        if(report.getImagedata()==null){
            throw new ReportImageNotUploadedException("Image Data not Uploaded");
        }else{
            reportsServiceImp.add_Report(report);
            return new ResponseEntity<>("Upload Done With Success", HttpStatus.CREATED) ;
        }

    }

    @GetMapping("/bins")
    public List<modernBin> get_AllBins(){

        return modernBinServiceImp.getAllBin() ;
    }

    @GetMapping("/trashcollectionSchedule")
    public List<trashCollectionSchedule> get_All_TrashCollection_Schedule(){

        return trashcollectionScheduleservice.getAllSchedule() ;
    }

}
