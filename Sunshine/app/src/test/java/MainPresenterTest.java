/**
 * Created by froriz on 9/29/15.
 */

import android.support.v7.widget.RecyclerView;

import com.sapient.froriz.sunshine.BuildConfig;
import com.sapient.froriz.sunshine.Presenter.MainPresenter;
import com.sapient.froriz.sunshine.Presenter.MainPresenterImpl;
import com.sapient.froriz.sunshine.R;
import com.sapient.froriz.sunshine.View.MainActivity;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import java_cup.Main;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for the Main Activity.
 * Created by Felipe Roriz on 9/25/15.
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

    @Test
    public void weatherDataListShouldBeEmptyWithNull() {
        presenter.setWeatherData(null);
        assertEquals(recyclerView.getAdapter().getItemCount(), 0);
    }

    @Test
    public void weatherDataListShouldBeFilled() {
        // Create list of mock WeatherEntry POJOs.
        List<WeatherEntry> weatherEntryList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            weatherEntryList.add(WeatherEntry.createWeatherEntry());
        }
        presenter.setWeatherData(weatherEntryList);
        assertEquals(recyclerView.getAdapter().getItemCount(), 7);
    }
}
