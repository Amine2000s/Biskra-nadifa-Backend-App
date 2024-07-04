package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.Report;

import java.util.List;
import java.util.Optional;

public interface reportsService {

    /**
     * INterfaces that COver Basic Report Entity Manipulation
     * Adding Report
     * deleting Report
     * Retreive All Stored Reports in the Databse
     * get Report by its id
     * get All Reports by the Cititzen id (Reported by him ) */


    public int updateReport(Report report);
    public int deleteReport(int  reportID);
    public Optional<Report> getReport(int reportID);
    public List<Report> getAllReports();

}
