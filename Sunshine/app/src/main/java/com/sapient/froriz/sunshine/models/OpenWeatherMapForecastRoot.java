package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * POJO Model for the Root JSON Object from Openweathermap API.
 * Created by froriz on 9/28/15.
 */
public class OpenWeatherMapForecastRoot extends OpenWeatherMapBase {
    @SerializedName("list") private List<OpenWeatherMapRoot> list;

    public List<OpenWeatherMapRoot> getList() {
        return list;
    }
}
