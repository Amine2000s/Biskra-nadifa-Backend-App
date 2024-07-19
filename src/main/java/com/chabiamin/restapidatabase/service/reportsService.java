package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.Report;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface reportsService {


    /**
     * Interface that Cover Basic Report Entity Manipulation
     * Adding Report
     * Retreive All Stored Reports in the Databse
     * get Report by its id
     * get All Reports by the Cititzen id (Reported by him )
     * deleting Report
     * */

    public String addReport(Report report) throws IOException;
    public Optional<Report> getReport(int reportID);
    public List<Report> getAllReports();


    public int deleteReport(int  reportID);




}
