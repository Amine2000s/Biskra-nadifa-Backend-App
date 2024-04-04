package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.Report;

import java.util.List;

public interface reportsService {

    public int updateReport(Report report);
    public int deleteReport(int  reportID);
    public Report getReport(int reportID);
    public List<Report> getAllReports();

}
