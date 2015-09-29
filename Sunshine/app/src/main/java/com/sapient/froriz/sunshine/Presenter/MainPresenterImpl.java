package com.sapient.froriz.sunshine.Presenter;


import com.sapient.froriz.sunshine.Networking.OpenWeatherApiInterface;
import com.sapient.froriz.sunshine.Networking.OpenWeatherMapWrapper;
import com.sapient.froriz.sunshine.View.MainView;
import com.sapient.froriz.sunshine.models.WeatherEntry;

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
     * Tells the Main Activity to use it's setWeatherData method with a given WeatherEntry.
     * @param weatherEntry WeatherEntry converted by the wrapper from the response given by the
     *                     Open Weather API.
     */
    @Override
    public void setWeatherData(WeatherEntry weatherEntry) {
        view.setWeatherData(weatherEntry);
    }

    /**
     * Check to see if the WeatherEntry is valid and not null.
     * @param weatherEntry WeatherEntry POJO.
     * @return A Valid WeatherEntry POJO.
     */
    @Override
    public WeatherEntry checkWeatherEntry(WeatherEntry weatherEntry) {
        if (weatherEntry == null) {
            weatherEntry = new WeatherEntry("", 0, 0, 0, "");
            weatherEntry.setToString("");
        }
        return weatherEntry;
    }

    /**
     * Tells the Wrapper to make the API call to Open Weather API with a given location.
     * @param location City name.
     */
    @Override
    public void makeApiCall(String location) {
        wrapper.getOpenWeatherMapRoot(location, this);
    }
}
