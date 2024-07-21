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
    public String create_Sugesstion(int citizenID, sugesstion sugesstion){

        normalUser user = normaluserRepository.getReferenceById(citizenID);
        sugesstion.setNormalUser(user);

        sugesstionRepository.save(sugesstion);

        return "Suggestion created With success" ;

    }

    @Override
    public void delete_Suggestion(int suggestionid) {

    }

    @Override
    public void get_User_Sugesstion_sbyUserId(int userId) {

    }

    @Override
    public List<sugesstion> get_All_Sugesstions() {


        List<sugesstion> suggestionList =  sugesstionRepository.findAll();

        return suggestionList ;

    }


}
