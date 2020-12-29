package com.mediscreen.msauthentication.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserLogin {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private boolean rememberUser;

    public UserLogin(String username, String password, boolean rememberUser) {
        this.username = username;
        this.password = password;
        this.rememberUser = rememberUser;
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

    public boolean isRememberUser() {
        return rememberUser;
    }

    public void setRememberUser(boolean rememberUser) {
        this.rememberUser = rememberUser;
    }
}
