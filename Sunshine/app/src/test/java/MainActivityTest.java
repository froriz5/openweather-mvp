import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.sapient.froriz.sunshine.BuildConfig;
import com.sapient.froriz.sunshine.Presenter.MainPresenter;
import com.sapient.froriz.sunshine.Presenter.MainPresenterImpl;
import com.sapient.froriz.sunshine.Utils.WeatherEntryAdapter;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for the Main Activity View.
 * Created by Felipe Roriz on 9/25/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    private MainActivity mainActivity;
    private RecyclerView recyclerView;

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        recyclerView = (RecyclerView) mainActivity.findViewById(R.id.recyclerView);
    }

    @Test
    public void weatherDataListShouldBeBeFilledWithEmptyList() {
        mainActivity.setWeatherData(new ArrayList<WeatherEntry>(7));
        assertEquals(recyclerView.getAdapter().getItemCount(), 0);
    }

    @Test
    public void weatherDataListShouldBeFilled() {
        // Create list of mock WeatherEntry POJOs.
        List<WeatherEntry> weatherEntryList = getTestList();
        mainActivity.setWeatherData(weatherEntryList);

        assertEquals(recyclerView.getAdapter().getItemCount(), 7);
    }

    /**
     * Helper method to generate a List of test WeatherEntry POJOs.
     * @return List of WeatherEntry POJOs.
     */
    private List<WeatherEntry> getTestList() {
        List<WeatherEntry> weatherEntryList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            weatherEntryList.add(WeatherEntry.createWeatherEntry());
        }
        return weatherEntryList;
    }
}
