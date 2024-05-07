package com.chabiamin.restapidatabase.controller;


import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.model.sugesstion;
import com.chabiamin.restapidatabase.repository.reportsRepository;
import com.chabiamin.restapidatabase.service.reportServiceImp;
import com.chabiamin.restapidatabase.service.suggestionService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/citizens")
public class citizenAPi {

    suggestionService suggestionService ;
    reportServiceImp reportServiceImp ;

    reportsRepository reportsrepository ;

    public static final String FOLDER_PATH = "C:\\Users\\amin\\Desktop\\Biskra_nadifa\\storedimages\\";

    @Autowired
    public citizenAPi ( reportServiceImp reportServiceImp1,
                        reportsRepository reportsrepository,
                        suggestionService suggestionservice){

        this.reportServiceImp = reportServiceImp1 ;
        this.reportsrepository = reportsrepository;
        this.suggestionService = suggestionservice ;


    }

    @PostMapping(path = "/report",consumes ={"application/*","multipart/form-data","application/octet-stream",MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public String createReport(@RequestPart("report") Report report,@RequestPart("image")@Nullable MultipartFile file) throws IOException {

        //String filepath=FOLDER_PATH+'report'.getImage();
        /*String filepath=FOLDER_PATH+report.getImage()+".png";
        file.transferTo(new File(filepath));*/
        //reportsrepository.save(report);,file
       // , @RequestPart(value = "image",required = false
        reportServiceImp.createReport(report,file);

        System.out.println(report.toString());
        System.out.println(report.toString());

        if(file.getBytes()!=null){
        return "report created successfully  " ;

    }else{
            System.out.println("nooooo image");

        return "report created successfully  , file is null  " ;

    }

    }


    @PostMapping("/suggestion")
    public String createReport(@RequestBody sugesstion suggestioninput){

        suggestionService.createSugesstion(suggestioninput);

        return "Suggestion saved succesffully " ;

    }

    @PostMapping(value = "/testing")
    public  String testing(@RequestBody Report report){


            System.out.println(report.toString());
       return "hello marouane habibi";

    }




}
