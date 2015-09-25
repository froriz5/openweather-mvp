package com.sapient.froriz.sunshine.Networking;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sapient.froriz.sunshine.BuildConfig;

import com.sapient.froriz.sunshine.Presenter.MainPresenter;
import com.sapient.froriz.sunshine.models.OpenWeatherMapRoot;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Wrapper for interacting with the Open Weather API.
 * Created by Felipe Roriz on 9/24/15.
 */
public class OpenWeatherMapWrapper implements OpenWeatherApiInterface{

    /**
     * Open Weather API Key
     */
    private final String apiKey = "b85620a2d87a970c2b801e0cec8c1689";

    /**
     * Type of unit to convert temperature in API call.
     */
    private String unitType = "imperial";


    private MainPresenter presenter;

    private OpenWeatherApi openWeatherApi;

    private GsonBuilder gsonBuilder;
    private Gson gson;
    private RestAdapter weatherRestAdapter;

    /**
     * Constructor for instantiating required components for Retrofit to work.
     */
    public OpenWeatherMapWrapper(MainPresenter presenter) {
        this.presenter = presenter;

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        weatherRestAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.openweathermap.org/")
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setConverter(new GsonConverter(gson))
                .build();

        openWeatherApi = weatherRestAdapter.create(OpenWeatherApi.class);
    }

    /**
     * Makes an asynchronous call to the Open Weather API and gets a JSON object of weather data.
     * @param location City name.
     * @param presenter The Presenter that will update a given view.
     */
    @Override
    public void getOpenWeatherMapRoot(final String location, final MainPresenter presenter) {

        openWeatherApi.getWeatherFromApi(location, apiKey, unitType, new Callback<OpenWeatherMapRoot>() {

            @Override
            public void success(OpenWeatherMapRoot openWeatherMapRoot, Response response) {
                WeatherEntry weatherEntry;
                // If response has response code 404, set weatherEntry to null.
                if (openWeatherMapRoot.getStatusCode() == 404) {
                    weatherEntry = null;
                }
                else {
                    weatherEntry = WeatherEntry.createWeatherEntry(location, openWeatherMapRoot);
                }
                presenter.setWeatherData(weatherEntry);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("WEATHER_WRAPPER_DEBUG", error.toString());
            }
        });
    }
}
