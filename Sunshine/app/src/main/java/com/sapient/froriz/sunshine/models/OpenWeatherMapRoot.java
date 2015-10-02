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
    @SerializedName("pressure") private double pressure; //hPa
    @SerializedName("humidty") private double humidity; // %
    @SerializedName("speed") private double windSpeed; // mph
    @SerializedName("deg") private double windDirection; // degrees (meteorogical)
    @SerializedName("clouds") private double cloudCoverage; // %

    public List<OpenWeatherMapWeather> getWeather() {
        return weather;
    }

    public OpenWeatherMapTemp getMain() {
        return temp;
    }

    public long getDate() {
        return date;
    }

    public double getCloudCoverage() {
        return cloudCoverage;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
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
