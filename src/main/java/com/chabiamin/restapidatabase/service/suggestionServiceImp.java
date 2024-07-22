package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.normalUser;
import com.chabiamin.restapidatabase.model.suggestion;
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
    public String create_Sugesstion(int citizenID, suggestion suggestion){

        normalUser user = normaluserRepository.getReferenceById(citizenID);
        suggestion.setNormalUser(user);

        sugesstionRepository.save(suggestion);

        return "Suggestion created With success" ;

    }

    @Override
    public void delete_Suggestion(int suggestionid) {

    }

    @Override
    public void get_User_Sugesstion_sbyUserId(int userId) {

    }

    @Override
    public List<suggestion> get_All_Sugesstions() {


        List<suggestion> suggestionList =  sugesstionRepository.findAll();

        return suggestionList ;

    }


}
