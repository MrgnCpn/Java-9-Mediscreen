package com.mediscreen.msauthentication.service;

import com.mediscreen.msauthentication.configuration.AppProperties;
import com.mediscreen.msauthentication.exception.NotAllowedException;
import com.mediscreen.msauthentication.exception.NotFoundException;
import com.mediscreen.msauthentication.interfaces.SecurityServiceInterface;
import com.mediscreen.msauthentication.interfaces.JwtServiceInterface;
import com.mediscreen.msauthentication.models.Jwt;
import com.mediscreen.msauthentication.models.UserLogin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SecurityService implements SecurityServiceInterface {
    /**
     * Token Service
     */
    private JwtServiceInterface jwtServiceInterface;

    /**
     * Password manager
     */
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * App properties
     */
    private AppProperties appProperties;

    /**
     * Constructor
     * @param jwtServiceInterface
     */
    public SecurityService(JwtServiceInterface jwtServiceInterface, BCryptPasswordEncoder passwordEncoder, AppProperties appProperties) {
        this.jwtServiceInterface = jwtServiceInterface;
        this.passwordEncoder = passwordEncoder;
        this.appProperties = appProperties;
    }

    /**
     * @see SecurityServiceInterface {@link #logUser(UserLogin)}
     */
    public Jwt logUser(UserLogin userLogin) {
        if (appProperties.getUsername() != null &&
            appProperties.getPassword() != null
        ){
            if (appProperties.getUsername().equals(userLogin.getUsername()) &&
                passwordEncoder.matches(userLogin.getPassword(), appProperties.getPassword())) {
                UUID uuid = UUID.randomUUID();
                Map<String, Object> claims = new HashMap<>();
                claims.put("userID", uuid.toString());
                claims.put("username", userLogin.getPassword());
                return jwtServiceInterface.createJWT(uuid, "Login", "Mediscreen", claims, (long) 60 * 60 * 24 * 90);
            } else {
                throw new NotAllowedException("Username and/or password are incorrect");
            }
        } else {
            throw new NotFoundException("User login informations are incomplete");
        }
    }

    /**
     * @see SecurityServiceInterface {@link #isLog(String)}
     */
    public boolean isLog(String token) {
        return ((token != null) && (jwtServiceInterface.parseJWT(token) != null));
    }
}
