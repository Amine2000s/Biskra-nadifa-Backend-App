package com.chabiamin.restapidatabase.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="suggestion")
public class sugesstion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="suggesterID")
    private normalUser normalUser ;

    @Column(name="suggestion-title")
            @Nullable
    String suggestionTitle;
    @Column(name="suggestion-description")
            @Nullable
    String suggestionDescription;

    @Column(name="created-at")
            @Nullable
    String createdAt ;

    public sugesstion() {
    }

    public sugesstion(int id, String suggestionTitle, String suggestionDescription) {
        this.id = id;
        this.suggestionTitle = suggestionTitle;
        this.suggestionDescription = suggestionDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getSuggestionTitle() {
        return suggestionTitle;
    }

    public void setSuggestionTitle(String suggestionTitle) {
        this.suggestionTitle = suggestionTitle;
    }

    public String getSuggestionDescription() {
        return suggestionDescription;
    }

    public void setSuggestionDescription(String suggestionDescription) {
        this.suggestionDescription = suggestionDescription;
    }

    public com.chabiamin.restapidatabase.model.normalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(com.chabiamin.restapidatabase.model.normalUser normalUser) {
        this.normalUser = normalUser;
    }

    public String getCreatAt() {
        return createdAt;
    }
}
