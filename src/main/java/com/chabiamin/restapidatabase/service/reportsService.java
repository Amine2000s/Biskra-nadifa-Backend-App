package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.Report;

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

    public String add_Report(Report report) throws IOException;
    public Optional<Report> get_Report(int reportID);
    public List<Report> get_AllReports();


    public String delete_Report(int  reportID);




}
