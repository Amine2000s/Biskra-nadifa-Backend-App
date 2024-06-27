package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.normalUser;
import com.chabiamin.restapidatabase.model.sugesstion;
import com.chabiamin.restapidatabase.repository.normalUserRepository;
import com.chabiamin.restapidatabase.repository.sugesstionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class suggestionService {

    @Autowired
    sugesstionsRepository sugesstionRepository;


    @Autowired
    normalUserRepository normaluserRepository ;



    public void createSugesstion(int citizenID,sugesstion sugesstioninput){

        normalUser user = normaluserRepository.getReferenceById(citizenID);
        sugesstioninput.setNormalUser(user);

        sugesstionRepository.save(sugesstioninput);

    }




}
