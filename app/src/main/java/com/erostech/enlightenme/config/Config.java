package com.erostech.enlightenme.config;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class Config {
    private static final String BASE_API_URL = "https://api.shutterstock.com/v2/";
    private static final String API_CLIENT_ID = "0b0da7db295b1294e9c9";
    private static final String API_CLIENT_SECRET = "a0e152bac41ad8ba9210ba3f3234c8152f1f19c2";
    private static final String DEFAULT_LANGUAGE = "en";

    public static String getApiUrl() {
        return BASE_API_URL;
    }

    public static String getApiClientId() {
        return API_CLIENT_ID;
    }

    public static String getApiClientSecret() {
        return API_CLIENT_SECRET;
    }

    public static String getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }
}
