package com.sapient.froriz.sunshine.View;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

    private TextView mTextViewCityName;
    private TextView mTextViewTempCurrent;
    private TextView mTextViewTempLow;
    private TextView mTextViewTempHigh;
    private TextView mTextViewWeatherDescription;

    private EditText mEditTextCityInput;
    private Button mButton;

    private ImageView mImageViewWeatherIcon;

    private CardView mCardView;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCityName = (TextView) findViewById(R.id.text_view_city_name);
        mTextViewTempCurrent = (TextView) findViewById(R.id.text_view_temp_current);
        mTextViewTempLow = (TextView) findViewById(R.id.text_view_temp_low);
        mTextViewTempHigh = (TextView) findViewById(R.id.text_view_temp_high);
        mTextViewWeatherDescription = (TextView) findViewById(R.id.text_view_weather_description);

        mImageViewWeatherIcon = (ImageView) findViewById(R.id.image_view_weather_icon);

        mCardView = (CardView) findViewById(R.id.card_view);

        mEditTextCityInput = (EditText)findViewById(R.id.edit_text_city_input);
        mButton = (Button)findViewById(R.id.button);

        presenter  = new MainPresenterImpl(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mEditTextCityInput.getText().toString();

                if (location.length() > 1) {
                    // Capitalize location name
                    location = location.substring(0, 1).toUpperCase() + location.substring(1);
                }
                presenter.makeApiCall(location);
            }
        });
    }

    /**
     * Updates the TextViews to display weather data from Open Weather API.
     * @param weatherEntry A model holding weather data.
     */
    @Override
    public void setWeatherData(WeatherEntry weatherEntry) {
        String weatherEntryToString = weatherEntry.toString();

        if (weatherEntryToString.equals("")) {
            Toast.makeText(this, "Invalid City Name", Toast.LENGTH_LONG).show();
        }
        else {
            mTextViewCityName.setText(weatherEntry.getLocation());
            mTextViewTempCurrent.setText("Current: "+weatherEntry.getCurrentTemp() + "\u00b0");
            mTextViewTempLow.setText("Low: "+weatherEntry.getLow() + "\u00b0");
            mTextViewTempHigh.setText("High: "+weatherEntry.getHigh() + "\u00b0");

            String desc = weatherEntry.getDescription();
            mTextViewWeatherDescription.setText(desc);

            mCardView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Method to set the Image Icon of the CardView to it's corresponding description.
     * Default of Clouds if different description.
     * @param description Description of the weather
     *                    (i.e. Clouds, Rain, Snow, Drizzle, Thunderstorm, Clear)
     */
    public void setWeatherCardIcon(String description) {
        mImageViewWeatherIcon.setImageDrawable(
                getImageDrawable(description));
    }

    /**
     * Helper method to get the correct Drawable from Resources given the icon description.
     * @param iconName Name describing the icon.
     * @return A Drawable to set to the ImageView of the CardView.
     */
    private Drawable getImageDrawable(String iconName) {
        int imageResource;

        switch (iconName) {
            case "Clouds":
                imageResource = getImageResource("@drawable/cloudy");
                break;
            case "Rain":
                imageResource = getImageResource("@drawable/rainy");
                break;
            case "Snow":
                imageResource = getImageResource("@drawable/snow");
                break;
            case "Drizzle":
                imageResource = getImageResource("@drawable/drizzle");
                break;
            case "Thunderstorm":
                imageResource = getImageResource("@drawable/thunderstorm");
                break;
            case "Clear":
                imageResource = getImageResource("@drawable/sunny");
                break;
            default:
                imageResource = getImageResource("@drawable/cloudy");
        }
        Drawable image = ContextCompat.getDrawable(this, imageResource);
        return image;
    }

    /**
     * Helper method to return the imageResource value to pass into the getImageResource method.
     * @param uri The path of the icon in the resources folder (i.e. @drawable/cloudy).
     * @return An int representing the resource value.
     */
    private int getImageResource(String uri) {
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        return imageResource;
    }
}
