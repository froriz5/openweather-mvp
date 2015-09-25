package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

/**
 * Base class where the OpenWeatherMapRoot will inherit from.
 * Created by Felipe Roriz on 9/25/15.
 */
public class OpenWeatherMapBase {
    // statusCode for handling when response has code 404. Response will be different then if
    // statusCode = 200.
    @SerializedName("cod") private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }
}
