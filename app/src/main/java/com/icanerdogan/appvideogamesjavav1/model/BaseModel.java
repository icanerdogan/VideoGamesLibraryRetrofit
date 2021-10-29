package com.icanerdogan.appvideogamesjavav1.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseModel {
    @SerializedName("results")
    private ArrayList<GameModel> game_results;

    public ArrayList<GameModel> getGame_results() {
        return game_results;
    }

    public void setGame_results(ArrayList<GameModel> game_results) {
        this.game_results = game_results;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "game_results=" + game_results +
                '}';
    }
}
