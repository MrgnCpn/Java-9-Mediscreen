package com.mediscreen.mspatientadmin.configuration;

import com.mediscreen.mspatientadmin.dao.PatientDao;
import com.mediscreen.mspatientadmin.interfaces.*;
import com.mediscreen.mspatientadmin.service.CountryService;
import com.mediscreen.mspatientadmin.service.HTTPRequestService;
import com.mediscreen.mspatientadmin.service.PatientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public AppProperties applicationProperties(){
        return new AppProperties();
    }

    @Bean
    public DatabaseConfigurationInterface databaseConfiguration() {
        return new DatabaseConfiguration(applicationProperties());
    }

    @Bean
    public HTTPRequestServiceInterface httpRequestService() {
        return new HTTPRequestService();
    }

    @Bean
    public CountryServiceInterface countryService(){
        return new CountryService(httpRequestService());
    }

    @Bean
    public PatientDaoInterface patientDao(){
        return new PatientDao(databaseConfiguration());
    }

    @Bean
    public PatientServiceInterface patientService() {
        return new PatientService(patientDao());
    }
}
