package com.chabiamin.restapidatabase.controller;


import com.chabiamin.restapidatabase.exception.ReportExceptions.ReportImageNotUploadedException;
import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.model.modernBin;
import com.chabiamin.restapidatabase.model.sugesstion;
import com.chabiamin.restapidatabase.model.trashCollectionSchedule;
import com.chabiamin.restapidatabase.repository.reportsRepository;
import com.chabiamin.restapidatabase.service.*;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
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


    //this folder path is used to prove that the images are recieved Correcttly
    public static final String FOLDER_PATH = "C:\\Users\\amin\\Desktop\\Biskra_nadifa\\storedimages\\";

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
    public String createsuggestion(@PathVariable int citizenId ,@RequestBody sugesstion suggestioninput){

        suggestionService.createSugesstion(citizenId,suggestioninput);

        return "Suggestion saved succesffully " ;

    }


    // The Client Send a Base64 String which represents the Image report

    @PostMapping(value = "/Report")
    public  String uploadReport(@RequestBody Report report) throws IOException {

        if(report.getImagedata()==null){
            throw new ReportImageNotUploadedException("Image Data not Uploaded");
        }else{



            // this Process transfome the Base64 String to the actual jpeg image , it's used to verify the Image Correctness 
            ByteArrayInputStream bis = new ByteArrayInputStream(report.getImagedata());
            BufferedImage image = ImageIO.read(bis);
            bis.close();

            // Save BufferedImage to file
            File outputFile = new File(FOLDER_PATH + "\\" + report.getImage() + "jpeg");
            ImageIO.write(image, "jpeg", outputFile);


            reportsServiceImp.addReport(report);

            return "Upload Done With Success";
        }


    }

    @GetMapping("/bins")
    public List<modernBin> getAllbins(){

        return modernBinServiceImp.getAllBin() ;
    }

    @GetMapping("/trashcollectionSchedule")
    public List<trashCollectionSchedule> getAlltrashcollectionSchedule(){

        return trashcollectionScheduleservice.getAllSchedule() ;
    }

}
