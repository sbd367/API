package com.example.wato.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String username;
    private final String password;
    private final int wins;
    private final int loss;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("username") String username,
                @JsonProperty("password") String password,
                @JsonProperty("wins") int wins,
                @JsonProperty("loss") int loss){
        this.id = id;
        this.username = username;
        this.password = password;
        this.wins = wins;
        this.loss = loss;
    }

    public UUID getId() {
        return id;
    }
    public int getWins() {
        return wins;
    }
    public int getLoss() {
        return loss;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {return password;}
}
