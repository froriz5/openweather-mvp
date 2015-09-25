package com.sapient.froriz.sunshine.Networking;


import com.sapient.froriz.sunshine.Presenter.MainPresenter;


/**
 * Interface to integrate the Main Presenter with the Wrapper for Open Weather.
 * Created by Felipe Roriz on 9/25/15.
 */
public interface OpenWeatherApiInterface {

    public void getOpenWeatherMapRoot(String location, MainPresenter presenter);
}
