package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.sugesstion;

import java.util.List;

public interface suggestionService {


    public String create_Sugesstion(int citizenID, sugesstion sugesstion);

    public void delete_Suggestion(int suggestionid);

    public void get_User_Sugesstion_sbyUserId(int userId);

    public List<sugesstion> get_All_Sugesstions();


}