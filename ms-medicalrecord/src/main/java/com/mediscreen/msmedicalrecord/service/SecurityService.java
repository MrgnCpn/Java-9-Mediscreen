package com.mediscreen.msmedicalrecord.service;

import com.mediscreen.msmedicalrecord.exception.EmptyDataException;
import com.mediscreen.msmedicalrecord.exception.NotAllowedException;
import com.mediscreen.msmedicalrecord.interfaces.SecurityServiceInterface;
import com.mediscreen.msmedicalrecord.proxy.MSAuthenticationProxy;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SecurityService implements SecurityServiceInterface {
    /**
     * ms-authentication proxy
     */
    @Autowired
    private MSAuthenticationProxy msAuthenticationProxy;

    public SecurityService() {
    }

    /**
     * @see SecurityServiceInterface {@link #authenticationCheck(String)}
     */
    @Override
    public void authenticationCheck(String token) {
        if (StringUtils.isBlank(token)) throw new EmptyDataException("The authentication token is required");
        ResponseEntity<Void> validation = msAuthenticationProxy.validateToken(token);
        if (!validation.getStatusCode().equals(HttpStatus.OK)) throw new NotAllowedException("Permission denied");
    }
}
