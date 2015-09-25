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
 * Unit Tests for the Main Activity.
 * Created by Felipe Roriz on 9/25/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    private MainActivity mainActivity;
    private WeatherEntry testWeatherEntry;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        testWeatherEntry = new WeatherEntry();
    }

    @Test
    public void textViewShouldBeEmptyWithNullData() {
        mainActivity.setWeatherData(null);

        TextView textView = (TextView) mainActivity.findViewById(R.id.textView);
        assertEquals(textView.getText().toString(), "");
    }

    @Test
    public void textViewShouldBeFilledWithData() {
        mainActivity.setWeatherData(testWeatherEntry);

        TextView textView = (TextView) mainActivity.findViewById(R.id.textView);
        assertEquals(textView.getText().toString(), testWeatherEntry.toString());
    }
}
