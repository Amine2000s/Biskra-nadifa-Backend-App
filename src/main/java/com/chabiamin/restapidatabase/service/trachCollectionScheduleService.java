package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.trashCollectionSchedule;

import java.util.ArrayList;
import java.util.List;

public interface trachCollectionScheduleService {


    public void addSchedule(trashCollectionSchedule trashcollectionschedule) ;

    public List<trashCollectionSchedule> getAllSchedule();


}
