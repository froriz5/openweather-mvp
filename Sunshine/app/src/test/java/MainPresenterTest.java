import com.sapient.froriz.sunshine.BuildConfig;
import com.sapient.froriz.sunshine.Presenter.MainPresenter;
import com.sapient.froriz.sunshine.Presenter.MainPresenterImpl;
import com.sapient.froriz.sunshine.View.MainActivity;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;



/**
 * Unit Tests for the Main View Presenter.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainPresenterTest {

    private MainActivity mainActivity;
    private MainPresenter presenter;
    private WeatherEntry testWeatherEntryEmpty;
    private WeatherEntry testWeatherEntryFilled;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        presenter = new MainPresenterImpl(mainActivity);
        testWeatherEntryEmpty = null;
        testWeatherEntryFilled = new WeatherEntry();
    }

    @Test
    public void nullWeatherEntryShouldCreateEmptyEntry() {
        testWeatherEntryEmpty = presenter.checkWeatherEntry(testWeatherEntryEmpty);
        assertNotEquals(testWeatherEntryEmpty, null);
        assertEquals(testWeatherEntryEmpty.toString(), "");
    }

    @Test
    public void validWeatherEntryShouldReturnSameEntry() {
        WeatherEntry newTestWeatherEntry = presenter.checkWeatherEntry(testWeatherEntryFilled);
        assertNotEquals(testWeatherEntryFilled, null);
        assertEquals(testWeatherEntryFilled, newTestWeatherEntry);
    }
}
