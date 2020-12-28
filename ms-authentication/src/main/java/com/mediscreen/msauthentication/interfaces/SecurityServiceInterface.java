package com.mediscreen.msauthentication.interfaces;

import com.mediscreen.msauthentication.models.Jwt;
import com.mediscreen.msauthentication.models.UserLogin;

public interface SecurityServiceInterface {
    /**
     * Log user
     * @param userLogin
     * @return
     */
    Jwt logUser(UserLogin userLogin);

    /**
     * Check if user is logging
     * @param token
     * @return
     */
    boolean isLog(String token);
}
