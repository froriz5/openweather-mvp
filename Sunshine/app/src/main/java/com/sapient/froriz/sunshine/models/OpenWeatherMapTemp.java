package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

/**
 * POJO Model for the "Temp" JSON Object
 * Created by froriz on 9/24/15.
 */
public class OpenWeatherMapTemp {

    @SerializedName("day") private double currentTemp;
    @SerializedName("min") private double low;
    @SerializedName("max") private double max;

    public double getCurrentTemp() {
        return currentTemp;
    }

    public double getLow() {
        return low;
    }

    public double getMax() {
        return max;
    }
}
