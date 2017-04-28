package com.erostech.enlightenme.config;

/**
 * Created by erosgarciaponte on 28/04/2017.
 */

public class Config {
    private static final String BASE_API_URL = "https://api.shutterstock.com/v2/";

    public static String getApiUrl() {
        return BASE_API_URL;
    }
}
