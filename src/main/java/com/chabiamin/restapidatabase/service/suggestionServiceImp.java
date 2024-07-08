package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.normalUser;
import com.chabiamin.restapidatabase.model.sugesstion;
import com.chabiamin.restapidatabase.repository.normalUserRepository;
import com.chabiamin.restapidatabase.repository.sugesstionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class suggestionServiceImp implements suggestionService{

    @Autowired
    sugesstionsRepository sugesstionRepository;


    @Autowired
    normalUserRepository normaluserRepository ;



    public suggestionServiceImp(sugesstionsRepository sgtrepository , normalUserRepository normaluserRepository){

        this.sugesstionRepository = sgtrepository;
        this.normaluserRepository = normaluserRepository ;


    }

    /**
     * Currently the responsible api endpoint sends the suggestion object alongside with the user Id
     *
     * */

    @Override
    public void createSugesstion(int citizenID,sugesstion sugesstion){

        normalUser user = normaluserRepository.getReferenceById(citizenID);
        sugesstion.setNormalUser(user);

        sugesstionRepository.save(sugesstion);

    }

    @Override
    public void deleteSuggestionb(int suggestionid) {

    }

    @Override
    public void getUserSugesstionsbyUserId(int userId) {

    }

    @Override
    public List<sugesstion> getAllSugesstions() {


        List<sugesstion> suggestionList =  sugesstionRepository.findAll();

        return suggestionList ;

    }


}
