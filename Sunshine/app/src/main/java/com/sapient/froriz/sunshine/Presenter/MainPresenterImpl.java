package com.sapient.froriz.sunshine.Presenter;


import com.sapient.froriz.sunshine.Networking.OpenWeatherApiInterface;
import com.sapient.froriz.sunshine.Networking.OpenWeatherMapWrapper;
import com.sapient.froriz.sunshine.View.MainView;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Main Activity Presenter to control the Main Activity.
 * Created by Felipe Roriz on 9/24/15.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private OpenWeatherApiInterface wrapper;

    /**
     * Constructor to instantiate the view and Open Weather API Wrapper for this Presenter to use.
     * @param view The Main Activity.
     */
    public MainPresenterImpl(MainView view) {
        this.view = view;
        wrapper  = new OpenWeatherMapWrapper(this);
    }

    /**
     * Tells the view to update it's Recycler View's weather data entries.
     * @param weatherEntries List of Weather Entry POJOs.
     */
    @Override
    public void setWeatherData(List<WeatherEntry> weatherEntries) {
        view.setWeatherData(weatherEntries);
    }

    /**
     * Check to see if list of WeatherEntries are valid.
     * @param weatherEntries List of WeatherEntry POJOs.
     * @return List of WeatherEntry POJOS.
     */
    @Override
    public List<WeatherEntry> checkWeatherData(List<WeatherEntry> weatherEntries) {
        if (weatherEntries == null) {
            // Return an empty list.
            return new ArrayList<WeatherEntry>(7);
        }
        return weatherEntries;
    }

    /**
     * Tells the Wrapper to make the API call to Open Weather API with a given location.
     * @param cityName City name.
     */
    @Override
    public void makeApiCall(String cityName) {
        wrapper.getOpenWeatherMapForecastRoot(cityName, this);
    }
}
