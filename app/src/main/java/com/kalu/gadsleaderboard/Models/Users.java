package com.kalu.gadsleaderboard.Models;

public class Users {
    String name;
    String country;
    int hours;
    int score;
    String badgeUrl;

    public Users(String name, String country, int hours, int score, String badgeUrl) {
        this.name = name;
        this.country = country;
        this.hours = hours;
        this.score = score;
        this.badgeUrl=badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
