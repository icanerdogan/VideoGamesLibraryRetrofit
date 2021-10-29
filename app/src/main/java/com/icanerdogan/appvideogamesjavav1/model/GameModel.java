package com.icanerdogan.appvideogamesjavav1.model;

import com.google.gson.annotations.SerializedName;

public class GameModel {
    @SerializedName("background_image")
    String game_image;
    @SerializedName("name")
    String game_name;
    @SerializedName("rating")
    Double game_rating;
    @SerializedName("released")
    String game_released;
    @SerializedName("metacritic")
    Integer game_metacritic;

    public GameModel(String game_image, String game_name, Double game_rating, String game_released, Integer game_metacritic) {
        this.game_image = game_image;
        this.game_name = game_name;
        this.game_rating = game_rating;
        this.game_released = game_released;
        this.game_metacritic = game_metacritic;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public Double getGame_rating() {
        return game_rating;
    }

    public void setGame_rating(Double game_rating) {
        this.game_rating = game_rating;
    }

    public String getGame_released() {
        return game_released;
    }

    public void setGame_released(String game_released) {
        this.game_released = game_released;
    }

    public String getGame_image() {
        return game_image;
    }

    public void setGame_image(String game_image) {
        this.game_image = game_image;
    }

    public Integer getGame_metacritic() {
        return game_metacritic;
    }

    public void setGame_metacritic(Integer game_metacritic) {
        this.game_metacritic = game_metacritic;
    }

    @Override
    public String toString() {
        return "GameModel{" +
                "game_image='" + game_image + '\'' +
                ", game_name='" + game_name + '\'' +
                ", game_rating=" + game_rating +
                ", game_released='" + game_released + '\'' +
                '}';
    }
}

