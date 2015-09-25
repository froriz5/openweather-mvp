package com.sapient.froriz.sunshine.Presenter;

import com.sapient.froriz.sunshine.models.WeatherEntry;

/**
 * Created by froriz on 9/25/15.
 */
public interface MainPresenter {

    public void setWeatherData(WeatherEntry weatherEntry);

    public void makeApiCall(String location);
}
