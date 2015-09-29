package com.sapient.froriz.sunshine.Presenter;

import com.sapient.froriz.sunshine.models.WeatherEntry;

import java.util.List;

/**
 * Created by froriz on 9/25/15.
 */
public interface MainPresenter {

    public void setWeatherData(List<WeatherEntry> weatherEntries);

    public List<WeatherEntry> checkWeatherData(List<WeatherEntry> weatherEntries);

    public void makeApiCall(String cityName);
}
