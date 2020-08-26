package com.udemy.rest.webservices.udemywebservices.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("usernameFilter")
public class UserCredentials {

    private String username;
    private String password;
    private String securityWord;

    public UserCredentials(String username, String password, String securityWord) {
        this.username = username;
        this.password = password;
        this.securityWord = securityWord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityWord() {
        return securityWord;
    }

    public void setSecurityWord(String securityWord) {
        this.securityWord = securityWord;
    }
}
