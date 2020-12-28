package com.mediscreen.mspatientadmin.model;

import com.mediscreen.mspatientadmin.service.CountryService;
import com.mediscreen.mspatientadmin.service.HTTPRequestService;

import javax.validation.constraints.NotNull;
import java.io.IOException;

public class Country {
    @NotNull(message = "CODE is mandatory")
    private String code;
    private String wording;
    private CountryService countryService;

    public Country() {
    }

    /**
     * Constructor
     * @param code
     * @throws IOException
     */
    public Country(String code) throws IOException {
        this.countryService = new CountryService(new HTTPRequestService());
        this.setCountry(code);
    }

    /**
     * Constructor
     * @param code
     * @param countryService
     * @throws IOException
     */
    public Country(String code, CountryService countryService) throws IOException {
        this.countryService = countryService;
        this.setCountry(code);
    }

    public String getCode() {
        return code;
    }

    public String getWording() {
        return wording;
    }

    public void setCountry(String code) throws IOException {
        this.code = code.toUpperCase();
        this.wording = countryService.getNameOfCountry(code.toUpperCase());
    }
}
