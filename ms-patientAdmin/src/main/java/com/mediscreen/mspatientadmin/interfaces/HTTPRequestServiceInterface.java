package com.mediscreen.mspatientadmin.interfaces;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

/**
 * @author MorganCpn
 */
public interface HTTPRequestServiceInterface {
    /**
     * API reader, HTTP GET request
     * @param url
     * @param urlParams
     * @return Content of API GET request
     * @throws IOException
     * @throws JSONException
     */
    JSONObject getReq(String url, Map<String, String> urlParams) throws IOException, JSONException;

    /**
     * Api POST request with a form
     * @param url
     * @param formParams
     * @return JSON api response
     * @throws IOException
     * @throws JSONException
     */
    JSONObject postFormReq(String url, Map<String, String> formParams) throws IOException, JSONException;
}
