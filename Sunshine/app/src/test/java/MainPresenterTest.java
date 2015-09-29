import android.support.v7.widget.RecyclerView;

import com.sapient.froriz.sunshine.BuildConfig;
import com.sapient.froriz.sunshine.Presenter.MainPresenter;
import com.sapient.froriz.sunshine.Presenter.MainPresenterImpl;
import com.sapient.froriz.sunshine.R;
import com.sapient.froriz.sunshine.View.MainActivity;
import com.sapient.froriz.sunshine.View.MainView;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for the Main View Presenter.
 * Created by Felipe Roriz on 9/29/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainPresenterTest {

    private MainActivity mainActivity;
    private MainPresenter presenter;
    private RecyclerView recyclerView;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        presenter = new MainPresenterImpl(mainActivity);
        recyclerView = (RecyclerView) mainActivity.findViewById(R.id.recyclerView);
    }

    /**
     * If list of WeatherEntries is null, should create an Empty List of size 7.
     */
    @Test
    public void nullListShouldCreateEmptyList() {
        int numEntries = presenter.checkWeatherData(null).size();
        assertEquals(numEntries, 0);
    }

    /**
     * If list of WeatherEntries is not null, should return the same list.
     */
    @Test
    public void validListShouldReturnSameList() {
        List<WeatherEntry> testEntries = getTestList();
        List<WeatherEntry> testEntriesChecked = presenter.checkWeatherData(testEntries);

        assertEquals(testEntries.size(), testEntriesChecked.size());
        assertEquals(testEntriesChecked, testEntries);
    }

    /**
     * Create a list of test WeatherEntry POJOs.
     * @return List of WeatherEntry POJOs.
     */
    public List<WeatherEntry> getTestList() {
        // Create list of mock WeatherEntry POJOs.
        List<WeatherEntry> weatherEntryList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            weatherEntryList.add(WeatherEntry.createWeatherEntry());
        }
        return weatherEntryList;
    }
}
