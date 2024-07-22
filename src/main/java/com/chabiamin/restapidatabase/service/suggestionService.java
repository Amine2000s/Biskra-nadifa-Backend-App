package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.suggestion;

import java.util.List;

public interface suggestionService {


    public String create_Sugesstion(int citizenID, suggestion suggestion);

    public void delete_Suggestion(int suggestionid);

    public void get_User_Sugesstion_sbyUserId(int userId);

    public List<suggestion> get_All_Sugesstions();


}