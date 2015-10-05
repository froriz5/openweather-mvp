package com.sapient.froriz.sunshine.View;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sapient.froriz.sunshine.R;
import com.sapient.froriz.sunshine.models.WeatherEntry;

/**
 * Created by froriz on 10/2/15.
 */
public class DetailActivity extends AppCompatActivity implements DetailView{

    private CardView mCardView;

    private TextView mTextViewCityName;
    private TextView mTextViewDate;
    private TextView mTextViewTempCurrent;
    private TextView mTextViewTempLow;
    private TextView mTextViewTempHigh;
    private TextView mTextViewWeatherDescription;
    private TextView mTextViewPressure;
    private TextView mTextViewHumidity;
    private TextView mTextViewWindSpeed;
    private TextView mTextViewWindDirection;
    private TextView mTextViewCloudCoverage;

    private ImageView mImageViewWeatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mCardView = (CardView) findViewById(R.id.detail_card_view);

        mTextViewCityName = (TextView) findViewById(R.id.detail_text_view_city_name);
        mTextViewDate = (TextView) findViewById(R.id.detail_text_view_date);
        mTextViewTempCurrent = (TextView) findViewById(R.id.detail_text_view_temp_current);
        mTextViewTempLow = (TextView) findViewById(R.id.detail_text_view_temp_low);
        mTextViewTempHigh = (TextView) findViewById(R.id.detail_text_view_temp_high);
        mTextViewWeatherDescription = (TextView) findViewById(R.id.detail_text_view_weather_description);
        mTextViewPressure = (TextView) findViewById(R.id.detail_text_view_pressure);
        mTextViewHumidity = (TextView) findViewById(R.id.detail_text_view_humidity);
        mTextViewWindSpeed = (TextView) findViewById(R.id.detail_text_view_wind_speed);
        mTextViewWindDirection = (TextView) findViewById(R.id.detail_text_view_wind_direction);
        mTextViewCloudCoverage = (TextView) findViewById(R.id.detail_text_view_cloud_coverage);

        mImageViewWeatherIcon = (ImageView) findViewById(R.id.detail_image_view_weather_icon);

        String desc = (String) getIntent().getExtras().get("description");
        setWeatherData(getIntent().getExtras());
        setWeatherCardIcon(desc);
    }


    @Override
    public void setWeatherData(Bundle weatherBundle) {
        if (weatherBundle.getBoolean("firstEntry")) {
            mTextViewTempCurrent.setText("Current: "+weatherBundle.getDouble("currentTemp")+"");
            mTextViewTempCurrent.setVisibility(View.VISIBLE);
        }

        mTextViewCityName.setText(weatherBundle.getString("location"));
        mTextViewDate.setText(weatherBundle.getString("date"));
        mTextViewTempLow.setText("Low: " + weatherBundle.getDouble("low") + "\u00b0");
        mTextViewTempHigh.setText("High: " + weatherBundle.getDouble("high") + "\u00b0");
        mTextViewWeatherDescription.setText(weatherBundle.getString("description"));
        mTextViewPressure.setText("Pressure: "+weatherBundle.getDouble("pressure")+"hPa");
        mTextViewHumidity.setText("Humidity: "+weatherBundle.getDouble("humidity") + "%");
        mTextViewWindSpeed.setText("Wind Speed: "+weatherBundle.getDouble("windSpeed")+"mph");
        mTextViewWindDirection.setText("Wind Direction: "+weatherBundle.getDouble("windDirection")+ "\u00b0");
        mTextViewCloudCoverage.setText("Cloud Coverage: "+weatherBundle.getDouble("cloudCoverage")+"%");
    }

    /**
     * Method to set the Image Icon of the CardView to it's corresponding description.
     * Default of Clouds if different description.
     * @param description Description of the weather
     *                    (i.e. Clouds, Rain, Snow, Drizzle, Thunderstorm, Clear)
     */
    @Override
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
