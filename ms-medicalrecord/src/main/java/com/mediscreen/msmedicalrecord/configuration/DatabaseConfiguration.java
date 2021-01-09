package com.mediscreen.msmedicalrecord.configuration;

import com.mediscreen.msmedicalrecord.interfaces.DatabaseConfigurationInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Singleton;

/**
 * Database configuration
 * @author MorganCpn
 */
@Singleton
public class DatabaseConfiguration implements DatabaseConfigurationInterface {
    /**
     * Logger log4j2
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Database host
     */
    private String host;

    /**
     * Database port
     */
    private String port;

    /**
     * Database database name
     */
    private String database;

    /**
     * Database username
     */
    private String user;

    /**
     * Database password
     */
    private String password;

    /**
     * Application properties
     */
    private AppProperties appProperties;

    /**
     * Constructor
     * @param appProperties
     */
    public DatabaseConfiguration(AppProperties appProperties) {
        this.appProperties = appProperties;
    }
}
