package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.sugesstion;
import com.chabiamin.restapidatabase.repository.sugesstionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class suggestionService {

    @Autowired
    sugesstionsRepository sugesstionRepository;


    public void createSugesstion(sugesstion sugesstioninput){

        sugesstionRepository.save(sugesstioninput);

    }




}
