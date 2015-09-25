package com.sapient.froriz.sunshine.Networking;


import com.sapient.froriz.sunshine.models.OpenWeatherMapRoot;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Interface to Integrate Retrofit with Open Weather API.
 * Created by Felipe Roriz on 9/24/15.
 */
public interface OpenWeatherApi {

    @GET("/data/2.5/weather")
    void getWeatherFromApi (
        @Query("q") String location,
        @Query("APPID") String apiKey,
        @Query("units") String units,
        Callback<OpenWeatherMapRoot> callback);
}
