package com.mediscreen.msauthentication.models;

import javax.validation.constraints.NotBlank;

public class UserLogin {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLogin() {
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
}
