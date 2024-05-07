package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.Report;

import java.util.List;
import java.util.Optional;

public interface reportsService {

    public int updateReport(Report report);
    public int deleteReport(int  reportID);
    public Optional<Report> getReport(int reportID);
    public List<Report> getAllReports();

}
