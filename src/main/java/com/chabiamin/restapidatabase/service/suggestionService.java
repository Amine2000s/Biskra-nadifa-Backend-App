package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.sugesstion;
import jdk.jshell.SourceCodeAnalysis;

public interface suggestionService {


    public void createSugesstion(int citizenID,sugesstion sugesstion);

    public void deleteSuggestionb(int suggestionid);

    public void getUserSugesstionsbyId(int userId);

    public void getSugesstion(int SuggestionId);


}