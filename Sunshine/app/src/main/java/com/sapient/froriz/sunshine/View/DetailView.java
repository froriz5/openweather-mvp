package com.sapient.froriz.sunshine.View;

import android.os.Bundle;

import com.sapient.froriz.sunshine.models.WeatherEntry;

/**
 * Created by froriz on 10/2/15.
 */
public interface DetailView {

    public void setWeatherData(Bundle weatherBundle);
    public void setWeatherCardIcon(String description);

}
