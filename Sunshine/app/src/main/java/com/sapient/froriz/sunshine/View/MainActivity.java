package com.sapient.froriz.sunshine.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sapient.froriz.sunshine.Networking.OpenWeatherApi;
import com.sapient.froriz.sunshine.Presenter.MainPresenter;
import com.sapient.froriz.sunshine.Presenter.MainPresenterImpl;
import com.sapient.froriz.sunshine.R;
import com.sapient.froriz.sunshine.Utils.WeatherEntryAdapter;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Activity for the Sunshine App.
 * Created by Felipe Roriz on 9/24/15
 */
public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<WeatherEntry> myDataset;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataset = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            myDataset.add(WeatherEntry.createWeatherEntry());
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new WeatherEntryAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

//        presenter  = new MainPresenterImpl(this);


    }

    /**
     * Updates the TextView to display weather data from Open Weather API.
     * @param weatherEntry A model holding weather data.
     */
//    @Override
//    public void setWeatherData(WeatherEntry weatherEntry) {
//        // weatherEntry will be null if entry from API not found (responseCode 404)
//        if (weatherEntry != null) {
//            mTextView.setText(weatherEntry.toString());
//        }
//        else {
//            mTextView.setText("");
//            Toast.makeText(this, "Invalid City Name", Toast.LENGTH_LONG).show();
//        }
//
//    }

    @Override
    public void setWeatherData(WeatherEntry weatherEntry) {


    }
}
