package com.mediscreen.mspatientadmin.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppPropertiesTest {
    private AppProperties appProperties;

    @BeforeEach
    void init_test(){
        this.appProperties = new AppProperties();
    }

    @Tag("AppPropertiesTest")
    @Test
    void productionDB_test(){
        appProperties.setHostProd("localhost");
        appProperties.setPortProd(1000);
        appProperties.setDatabaseProd("DB");
        appProperties.setUserProd("user");
        appProperties.setPasswordProd("password");

        assertThat(appProperties.getHostProd()).isEqualTo("localhost");
        assertThat(appProperties.getPortProd()).isEqualTo(1000);
        assertThat(appProperties.getDatabaseProd()).isEqualTo("DB");
        assertThat(appProperties.getUserProd()).isEqualTo("user");
        assertThat(appProperties.getPasswordProd()).isEqualTo("password");
    }

    @Tag("AppPropertiesTest")
    @Test
    void testDB_test(){
        appProperties.setHostTest("localhost_test");
        appProperties.setPortTest(2000);
        appProperties.setDatabaseTest("DB_test");
        appProperties.setUserTest("user_test");
        appProperties.setPasswordTest("password_test");

        assertThat(appProperties.getHostTest()).isEqualTo("localhost_test");
        assertThat(appProperties.getPortTest()).isEqualTo(2000);
        assertThat(appProperties.getDatabaseTest()).isEqualTo("DB_test");
        assertThat(appProperties.getUserTest()).isEqualTo("user_test");
        assertThat(appProperties.getPasswordTest()).isEqualTo("password_test");
    }
}