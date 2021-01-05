package com.mediscreen.msclientui.service;

import com.mediscreen.msclientui.exception.EmptyDataException;
import com.mediscreen.msclientui.exception.NotAllowedException;
import com.mediscreen.msclientui.interfaces.SecurityServiceInterface;
import com.mediscreen.msclientui.models.Login;
import com.mediscreen.msclientui.proxy.MSZuulProxy;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class SecurityService implements SecurityServiceInterface {
    /**
     * Zuul proxy
     */
    @Autowired
    private MSZuulProxy msZuulProxy;

    public SecurityService() {
    }

    /**
     * @see SecurityServiceInterface {@link #authenticationCheck(String)}
     */
    @Override
    public void authenticationCheck(String token) {
        if (StringUtils.isBlank(token)) throw new EmptyDataException("The authentication token is required");
        ResponseEntity<Void> validation = msZuulProxy.msAuthentication_validateToken(token);
        if (!validation.getStatusCode().equals(HttpStatus.OK)) throw new NotAllowedException("Permission denied");
    }

    /**
     * @see SecurityServiceInterface {@link #isLog(HttpSession)}
     */
    @Override
    public boolean isLog(HttpSession session){
        return true;
    }

    /**
     * @see SecurityServiceInterface {@link #logUser(Login)}
     */
    @Override
    public Map<String, String> logUser(Login login){
        return null;
    }
}
