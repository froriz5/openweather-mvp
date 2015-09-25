package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

/**
 * POJO Model for the "Main" JSON Object
 * Created by froriz on 9/24/15.
 */
public class OpenWeatherMapMain {

    @SerializedName("temp") private double currentTemp;
    @SerializedName("pressure") private double pressure;
    @SerializedName("humidity") private double humidity;
    @SerializedName("temp_min") private double low;
    @SerializedName("temp_max") private double max;

    public double getCurrentTemp() {
        return currentTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getLow() {
        return low;
    }

    public double getMax() {
        return max;
    }
}
