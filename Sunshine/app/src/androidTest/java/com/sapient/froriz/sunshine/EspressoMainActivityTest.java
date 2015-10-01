package com.sapient.froriz.sunshine;

import android.support.test.InstrumentationRegistry;
import android.support.v7.widget.CardView;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sapient.froriz.sunshine.View.MainActivity;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import org.junit.Before;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


/**
 * Created by froriz on 10/1/15.
 */
public class EspressoMainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private MainActivity activity;
    private WeatherEntry testWeatherEntryEmpty;
    private WeatherEntry testWeatherEntryFilled;

    private TextView mTextViewCityName;
    private TextView mTextViewTempCurrent;
    private TextView mTextViewTempLow;
    private TextView mTextViewTempHigh;
    private TextView mTextViewWeatherDescription;

    private ImageView mImageViewWeatherIcon;

    private CardView mCardView;

    public EspressoMainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();

        testWeatherEntryEmpty = new WeatherEntry("", 0, 0, 0, "");
        testWeatherEntryEmpty.setToString("");
        testWeatherEntryFilled = new WeatherEntry();


//        mTextViewCityName = (TextView) activity.findViewById(R.id.text_view_city_name);
//        mTextViewTempCurrent = (TextView) activity.findViewById(R.id.text_view_temp_current);
//        mTextViewTempLow = (TextView) activity.findViewById(R.id.text_view_temp_low);
//        mTextViewTempHigh = (TextView) activity.findViewById(R.id.text_view_temp_high);
//        mTextViewWeatherDescription = (TextView) activity.findViewById(R.id.text_view_weather_description);
//        mImageViewWeatherIcon = (ImageView) activity.findViewById(R.id.image_view_weather_icon);
//
//        mCardView = (CardView) activity.findViewById(R.id.card_view);
    }

    public void testCardChanged() {
//        onView(withId(R.id.card_view).matches())
//        assertEquals(mCardView.getVisibility(), View.VISIBLE);
//        activity.setWeatherData(testWeatherEntryFilled);

//        assertEquals(mTextViewCityName.getText().toString(), testWeatherEntryFilled.getLocation());

    }
}
