package com.mediscreen.mspatientadmin.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mediscreen-ms-patient-admin-db")
public class AppProperties {
    private String hostProd;
    private Integer portProd;
    private String databaseProd;
    private String userProd;
    private String passwordProd;

    public String getHostProd() {
        return hostProd;
    }

    public void setHostProd(String hostProd) {
        this.hostProd = hostProd;
    }

    public Integer getPortProd() {
        return portProd;
    }

    public void setPortProd(Integer portProd) {
        this.portProd = portProd;
    }

    public String getDatabaseProd() {
        return databaseProd;
    }

    public void setDatabaseProd(String databaseProd) {
        this.databaseProd = databaseProd;
    }

    public String getUserProd() {
        return userProd;
    }

    public void setUserProd(String userProd) {
        this.userProd = userProd;
    }

    public String getPasswordProd() {
        return passwordProd;
    }

    public void setPasswordProd(String passwordProd) {
        this.passwordProd = passwordProd;
    }

    private String hostTest;
    private Integer portTest;
    private String databaseTest;
    private String userTest;
    private String passwordTest;

    public String getHostTest() {
        return hostTest;
    }

    public void setHostTest(String hostTest) {
        this.hostTest = hostTest;
    }

    public Integer getPortTest() {
        return portTest;
    }

    public void setPortTest(Integer portTest) {
        this.portTest = portTest;
    }

    public String getDatabaseTest() {
        return databaseTest;
    }

    public void setDatabaseTest(String databaseTest) {
        this.databaseTest = databaseTest;
    }

    public String getUserTest() {
        return userTest;
    }

    public void setUserTest(String userTest) {
        this.userTest = userTest;
    }

    public String getPasswordTest() {
        return passwordTest;
    }

    public void setPasswordTest(String passwordTest) {
        this.passwordTest = passwordTest;
    }
}
