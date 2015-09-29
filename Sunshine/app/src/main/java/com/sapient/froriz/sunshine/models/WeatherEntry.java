package com.sapient.froriz.sunshine.models;

/**
 * Weather Entry class to hold information about a given day's weather.
 * Created by Felipe Roriz on 9/24/15.
 */
public class WeatherEntry {

    private String location;
    private double currentTemp;
    private double low;
    private double high;
    private String description;
    private String toString;

    /**
     * Dummy data in case a test model is needed.
     */
    public WeatherEntry() {
        this("Chicago", 72, 60, 75, "Cloudy");
    }

    /**
     * Constructor for creating a WeatherEntry POJO.
     * @param location City name.
     * @param currentTemp Current Temperature.
     * @param low Low of the day.
     * @param high High of the day.
     * @param description Description (i.e. Cloudy, Sunny, etc...)
     */
    public WeatherEntry(String location, double currentTemp, double low,
                        double high, String description) {
        this.location = location;
        this.currentTemp = currentTemp;
        this.low = low;
        this.high = high;
        this.description = description;
        toString = location +" ---- "+
                "Current: " + currentTemp + " --- " +
                "Low: " + low + " --- " +
                "High: " + high;

    }

    @Override
    public String toString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }

    /**
     * Factory method for creating a WeatherEntry model with given data.
     * @param location City name
     * @param root JSON object representing the root object from Open Weather API Response.
     * @return WeatherEntry with the provided data.
     */
    public static WeatherEntry createWeatherEntry(String location, OpenWeatherMapRoot root) {
        WeatherEntry weatherEntry = new WeatherEntry(
                location,
                root.getMain().getCurrentTemp(),
                root.getMain().getLow(),
                root.getMain().getMax(),
                root.getWeather().get(0).getDescription()
        );
        return weatherEntry;
    }

}
