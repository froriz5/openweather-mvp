
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.sapient.froriz.sunshine.BuildConfig;
import com.sapient.froriz.sunshine.View.MainActivity;
import com.sapient.froriz.sunshine.R;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.assertEquals;
import static org.assertj.android.api.Assertions.assertThat;

/**
 * Unit Tests for the Main Activity View.
 * Created by Felipe Roriz on 9/25/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    private MainActivity mainActivity;
    private WeatherEntry testWeatherEntryEmpty;
    private WeatherEntry testWeatherEntryFilled;

    private TextView mTextViewCityName;
    private TextView mTextViewTempCurrent;
    private TextView mTextViewTempLow;
    private TextView mTextViewTempHigh;
    private TextView mTextViewWeatherDescription;

    private CardView mCardView;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        testWeatherEntryEmpty = new WeatherEntry("", 0, 0, 0, "");
        testWeatherEntryEmpty.setToString("");
        testWeatherEntryFilled = new WeatherEntry();

        mTextViewCityName = (TextView) mainActivity.findViewById(R.id.text_view_city_name);
        mTextViewTempCurrent = (TextView) mainActivity.findViewById(R.id.text_view_temp_current);
        mTextViewTempLow = (TextView) mainActivity.findViewById(R.id.text_view_temp_low);
        mTextViewTempHigh = (TextView) mainActivity.findViewById(R.id.text_view_temp_high);
        mTextViewWeatherDescription = (TextView) mainActivity.findViewById(R.id.text_view_weather_description);

        mCardView = (CardView) mainActivity.findViewById(R.id.card_view);
    }

    @Test
    public void textViewShouldBeEmptyWithNullData() {
        assertThat(mCardView).isNotVisible();
        mainActivity.setWeatherData(testWeatherEntryEmpty);

        assertThat(mCardView).isNotVisible();

    }

    @Test
    public void textViewsShouldBeFilledWithData() {
        assertThat(mCardView).isNotVisible();
        mainActivity.setWeatherData(testWeatherEntryFilled);

        assertThat(mCardView).isVisible();

        assertEquals(mTextViewCityName.getText().toString(), testWeatherEntryFilled.getLocation());
        assertEquals(mTextViewTempCurrent.getText().toString(), "Current: "+testWeatherEntryFilled.getCurrentTemp() + "°");
        assertEquals(mTextViewTempLow.getText().toString(), "Low: "+testWeatherEntryFilled.getLow() + "°");
        assertEquals(mTextViewTempHigh.getText().toString(), "High: "+testWeatherEntryFilled.getHigh() + "°");
        assertEquals(mTextViewWeatherDescription.getText().toString(), testWeatherEntryFilled.getDescription());



    }
}