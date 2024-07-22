package com.chabiamin.restapidatabase.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="suggestion")
public class suggestion {

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

    public suggestion(int id, normalUser user, String suggestionTitle, String suggestionDescription) {
        this.id = id;
        this.normalUser = user ;
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
