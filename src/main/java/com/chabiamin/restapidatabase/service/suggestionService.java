package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.sugesstion;
import jdk.jshell.SourceCodeAnalysis;

import java.util.List;

public interface suggestionService {


    public String createSugesstion(int citizenID,sugesstion sugesstion);

    public void deleteSuggestionb(int suggestionid);

    public void getUserSugesstionsbyUserId(int userId);

    public List<sugesstion> getAllSugesstions();


}