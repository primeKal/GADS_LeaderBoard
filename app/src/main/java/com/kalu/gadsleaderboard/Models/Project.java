package com.kalu.gadsleaderboard.Models;

public class Project {
    String firstname;
    String lastname;
    String githublink;
    String emailaddress;

    public Project(String firstname, String lastname, String githublink, String emailaddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.githublink = githublink;
        this.emailaddress = emailaddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGithublink() {
        return githublink;
    }

    public void setGithublink(String githublink) {
        this.githublink = githublink;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
}
