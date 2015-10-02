package com.sapient.froriz.sunshine.models;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Weather Entry class to hold information about a given day's weather.
 * Created by Felipe Roriz on 9/24/15.
 */
public class WeatherEntry {

    private long date;
    private String location;
    private double currentTemp;
    private double low;
    private double high;
    private String description;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDirection;
    private double cloudCoverage;

    /**
     * Dummy data in case a test model is needed.
     */
    public WeatherEntry() {
        this(0, "Chicago", 72, 60, 75, "Cloudy");
    }

    /**
     * Constructor for creating a WeatherEntry POJO.
     * @param date Date in UTC time format.
     * @param location City name.
     * @param currentTemp Current Temperature.
     * @param low Low of the day.
     * @param high High of the day.
     * @param description Description (i.e. Cloudy, Sunny, etc...)
     */
    public WeatherEntry(long date, String location, double currentTemp, double low,
                        double high, String description) {
        this.date = date;
        this.location = location;
        this.currentTemp = currentTemp;
        this.low = low;
        this.high = high;
        this.description = description;
    }

    /**
     * Constructor for creating a WeatherEntry POJO for a Detail Activity.
     * @param date Date in UTC time format.
     * @param location City name.
     * @param currentTemp Current Temperature.
     * @param low Low of the day.
     * @param high High of the day.
     * @param description Description (i.e. Cloudy, Sunny, etc...)
     * @param pressure Pressure measured in hPa.
     * @param humidity Humidty measure in %.
     * @param windSpeed Wind Speed measured in mph.
     * @param windDirection Wind Direction measured in degrees.
     * @param cloudCoverage Cloud coverage measured in %.
     */
    public WeatherEntry(long date, String location, double currentTemp, double low,
                        double high, String description, double pressure, double humidity,
                        double windSpeed, double windDirection, double cloudCoverage) {
        this.date = date;
        this.location = location;
        this.currentTemp = currentTemp;
        this.low = low;
        this.high = high;
        this.description = description;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudCoverage = cloudCoverage;
    }

    public long getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public String getDescription() {
        return description;
    }

    public String getFormattedDate() {
        return convertDateFromUTCFormat(date);
    }

    /**
     * Format UTC time in milliseconds to local time.
     * @param date Time in Unix Milliseconds for the UTC Time Zone.
     * @return Friendly formatted String of the date.
     */
    private String convertDateFromUTCFormat(long date) {
        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(date*1000L);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d");
        sdf.setTimeZone(TimeZone.getDefault());
        String formattedDate = sdf.format(calendar.getTime());
        return formattedDate;
    }

    @Override
    public String toString() {
        return location +" ---- "+
                convertDateFromUTCFormat(date) + " --- " +
                "Current: " + currentTemp + " --- " +
                "Low: " + low + " --- " +
                "High: " + high;
    }

    /**
     * Factory method for creating a dummy Weather Entry POJO.
     * @return
     */
    public static WeatherEntry createWeatherEntry() {
        WeatherEntry weatherEntry = new WeatherEntry(0, "Chicago", 65, 55, 70, "Cloudy");
        return weatherEntry;
    }

    /**
     * Factory method for creating a WeatherEntry model with given data.
     * @param location City name
     * @param root JSON object representing the root object from Open Weather API Response.
     * @return WeatherEntry with the provided data.
     */
    public static WeatherEntry createWeatherEntry(long date, String location, OpenWeatherMapRoot root) {
        WeatherEntry weatherEntry = new WeatherEntry(
                date,
                location,
                root.getMain().getCurrentTemp(),
                root.getMain().getLow(),
                root.getMain().getMax(),
                root.getWeather().get(0).getDescription(),
                root.getPressure(),
                root.getHumidity(),
                root.getWindSpeed(),
                root.getWindDirection(),
                root.getCloudCoverage()
        );
        return weatherEntry;
    }

    /**
     * Factory method for creating a list of Weather Entries.
     * @param cityName City Name.
     * @param list A list of the JSON object representing the root object of an Open Weather API Response.
     * @return List of WeatherEntries.
     */
    public static List<WeatherEntry> createWeatherEntryList(String cityName, List<OpenWeatherMapRoot> list) {
        if (list == null) {
            return null;
        }
        List<WeatherEntry> weatherEntries = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            weatherEntries.add(WeatherEntry.createWeatherEntry(list.get(i).getDate(), cityName, list.get(i)));
        }
        return weatherEntries;
    }

    public Bundle getWeatherBundle() {
        Bundle weatherBundle = new Bundle();
        weatherBundle.putCharSequence("date", getFormattedDate());
        weatherBundle.putCharSequence("location", location);
        weatherBundle.putDouble("currentTemp", currentTemp);
        weatherBundle.putDouble("low", low);
        weatherBundle.putDouble("high", high);
        weatherBundle.putCharSequence("description", description);
        return weatherBundle;
    }
}
