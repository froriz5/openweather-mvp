package com.sapient.froriz.sunshine.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.sapient.froriz.sunshine.models.WeatherEntry;

/**
 * Main Activity for the Sunshine App.
 * Created by Felipe Roriz on 9/24/15
 */
public class MainActivity extends AppCompatActivity implements MainView {

    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.textView);
        mEditText = (EditText)findViewById(R.id.editText);
        mButton = (Button)findViewById(R.id.button);

        presenter  = new MainPresenterImpl(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mEditText.getText().toString();

                if (location.length() > 1) {
                    // Capitalize location name
                    location = location.substring(0, 1).toUpperCase() + location.substring(1);
                }
                presenter.makeApiCall(location);
            }
        });
    }

    /**
     * Updates the TextView to display weather data from Open Weather API.
     * @param weatherEntry A model holding weather data.
     */
    @Override
    public void setWeatherData(WeatherEntry weatherEntry) {
        String weatherIntryToString = weatherEntry.toString();
        if (weatherIntryToString.equals("")) {
            mTextView.setText("");
            Toast.makeText(this, "Invalid City Name", Toast.LENGTH_LONG).show();
        }
        else {
            mTextView.setText(weatherIntryToString);
        }

    }
}
