package com.chabiamin.restapidatabase.service;


import com.chabiamin.restapidatabase.model.Report;
import com.chabiamin.restapidatabase.repository.reportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class reportsServiceImp implements reportsService  {

    reportsRepository reportsrepository ;
    @Autowired
    public reportsServiceImp(reportsRepository reportsrepository){

        this.reportsrepository = reportsrepository;

    }
    @Override
    public void addReport(Report report) throws IOException {

        //TODO :
        //replace Console Printing with logs ,
        System.out.println("sql query inserted");

        reportsrepository.save(report);



    }

    @Override

    public void addReport(Report report,MultipartFile file) throws IOException {

        //if(file!=null), MultipartFile file
        // report.setImagedata(imageUtils.compressImage(file.getBytes()));
        System.out.println("sql query inserted");
        reportsrepository.save(report);



    }


    @Override

    public int deleteReport(int reportID) {

        reportsrepository.deleteById(reportID);


        System.out.println(" hello from reportService imp");

        return 1;
    }
    @Override

    public Optional<Report> getReport(int reportID) {

        if(reportsrepository.findById(reportID).isEmpty()){
            return  null ;
        }else {

            return reportsrepository.findById(reportID);
        }
    }

    @Override
    public Optional<List<Report>> getReportsByUserId(int UserId) {
        return Optional.empty();
    }

    @Override

    public List<Report> getAllReports() {


        List<Report> templist = reportsrepository.findAll();

        for (Report report:templist) {

            /*byte[] temp = report.getImagedata();
            if(temp==null)continue;

            report.setImagedata(imageUtils.decompressImage(temp));
*/
        }

        return templist;
    }




    public String UploadImagedata(Report report){
        return  "";
    }


}