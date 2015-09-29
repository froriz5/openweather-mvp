package com.sapient.froriz.sunshine.Presenter;

import com.sapient.froriz.sunshine.models.WeatherEntry;

import java.util.List;

/**
 * Created by froriz on 9/25/15.
 */
public interface MainPresenter {

    public void setWeatherData(WeatherEntry weatherEntry);

    public WeatherEntry checkWeatherEntry(WeatherEntry weatherEntry);

    public void makeApiCall(String location);
}
