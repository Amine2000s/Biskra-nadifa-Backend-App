package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.trashCollectionSchedule;
import com.chabiamin.restapidatabase.repository.trashCollectionScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
 @Repository
public class trashCollectionScheduleServiceImp implements trachCollectionScheduleService{

    @Autowired
    trashCollectionScheduleRepository trashCollectionschedulerepository;
    @Override
    public void addSchedule(trashCollectionSchedule trashcollectionschedule) {
        trashCollectionschedulerepository.save(trashcollectionschedule);
    }

    @Override
    public List<trashCollectionSchedule> getAllSchedule() {
        return trashCollectionschedulerepository.findAll();
    }
}
