package com.sapient.froriz.sunshine.View;

import com.sapient.froriz.sunshine.models.WeatherEntry;

import java.util.List;

/**
 * Interface to integrate Main Activity with Main Presenter.
 * Created by Felipe Roriz on 9/25/15.
 */
public interface MainView {

    public void setWeatherData(List<WeatherEntry> weatherEntries);
}
