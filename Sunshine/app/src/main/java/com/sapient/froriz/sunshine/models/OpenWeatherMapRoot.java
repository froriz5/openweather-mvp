package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * POJO Model for the Root JSON Object from Openweathermap API.
 * Created by froriz on 9/24/15.
 */
public class OpenWeatherMapRoot extends OpenWeatherMapBase {

    @SerializedName("weather") private List<OpenWeatherMapWeather> weather;
    @SerializedName("main") private OpenWeatherMapMain main;

    public List<OpenWeatherMapWeather> getWeather() {
        return weather;
    }

    public OpenWeatherMapMain getMain() {
        return main;
    }

    @Override
    public String toString() {
        String toReturn = "";
        toReturn += weather.get(0).getDescription() + ", " +
                "Low: " + main.getLow() + " " +
                "High: " + main.getMax() + " " +
                "Current: " + main.getCurrentTemp();
        return toReturn;
    }
}
