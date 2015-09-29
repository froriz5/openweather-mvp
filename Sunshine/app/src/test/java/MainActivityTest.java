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

import static org.junit.Assert.assertEquals;

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

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        testWeatherEntryEmpty = new WeatherEntry("", 0, 0, 0, "");
        testWeatherEntryEmpty.setToString("");
        testWeatherEntryFilled = new WeatherEntry();
    }

    @Test
    public void textViewShouldBeEmptyWithNullData() {
        mainActivity.setWeatherData(testWeatherEntryEmpty);

        TextView textView = (TextView) mainActivity.findViewById(R.id.textView);
        assertEquals(textView.getText().toString(), "");
    }

    @Test
    public void textViewShouldBeFilledWithData() {
        mainActivity.setWeatherData(testWeatherEntryFilled);

        TextView textView = (TextView) mainActivity.findViewById(R.id.textView);
        assertEquals(textView.getText().toString(), testWeatherEntryFilled.toString());
    }
}
