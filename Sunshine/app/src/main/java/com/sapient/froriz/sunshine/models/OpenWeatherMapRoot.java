package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * POJO Model for the Root JSON Object from Openweathermap API.
 * Created by froriz on 9/24/15.
 */
public class OpenWeatherMapRoot extends OpenWeatherMapBase {

    @SerializedName("weather") private List<OpenWeatherMapWeather> weather;
    @SerializedName("temp") private OpenWeatherMapTemp temp;
    @SerializedName("dt") private long date;

    public List<OpenWeatherMapWeather> getWeather() {
        return weather;
    }

    public OpenWeatherMapTemp getMain() {
        return temp;
    }

    public long getDate() {
        return date;
    }

    @Override
    public String toString() {
        String toReturn = "";
        toReturn += weather.get(0).getDescription() + ", " +
                "Low: " + temp.getLow() + " " +
                "High: " + temp.getMax() + " " +
                "Current: " + temp.getCurrentTemp();
        return toReturn;
    }
}
