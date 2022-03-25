package com.example.wato.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Bet {
    private final UUID id;
    private final String betName;
    private final int[] wagers;

    public Bet(@JsonProperty UUID id, @JsonProperty String betName, @JsonProperty int[] wagers){
        this.betName = betName;
        this.wagers = wagers;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    public String getBet() {
        return betName;
    }
    public int[] getWagers(){
        return wagers;
    }
}
