package com.sapient.froriz.sunshine.models;

import com.google.gson.annotations.SerializedName;

/**
 * POJO Model for the "Weather" JSON Object
 * Created by froriz on 9/24/15.
 */
public class OpenWeatherMapWeather {
    @SerializedName("id") private int id;
    @SerializedName("main") private String description;
    @SerializedName("description") private String detailedDescription;
    @SerializedName("icon") private String icon;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public String getIcon() {
        return icon;
    }
}
