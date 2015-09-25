package com.sapient.froriz.sunshine.View;

import com.sapient.froriz.sunshine.models.WeatherEntry;

/**
 * Interface to integrate Main Activity with Main Presenter.
 * Created by Felipe Roriz on 9/25/15.
 */
public interface MainView {

    public void setWeatherData(WeatherEntry weatherEntry);
}
