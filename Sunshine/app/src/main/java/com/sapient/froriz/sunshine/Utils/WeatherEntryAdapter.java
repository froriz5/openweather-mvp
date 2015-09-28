package com.sapient.froriz.sunshine.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sapient.froriz.sunshine.R;
import com.sapient.froriz.sunshine.models.WeatherEntry;

import java.util.List;

/**
 * Weather Entry Adapter for the Weather Entry Recycler View.
 * Created by Felipe Roriz on 9/28/15.
 */
public class WeatherEntryAdapter extends RecyclerView.Adapter<WeatherEntryAdapter.ViewHolder> {

    /**
     * List of Weather Entry POJOs.
     */
    private List<WeatherEntry> weatherEntryDataset;

    /**
     * Constructor for initializing the adapter's dataset.
     * @param weatherEntryDataset List of Weather Entry POJOs.
     */
    public WeatherEntryAdapter(List<WeatherEntry> weatherEntryDataset) {
        this.weatherEntryDataset = weatherEntryDataset;
    }

    /**
     * Set the dataset after a new list is created.
     * @param weatherEntryDataset List of Weather Entry POJOs.
     */
    public void setWeatherEntryDataset(List<WeatherEntry> weatherEntryDataset) {
        this.weatherEntryDataset = weatherEntryDataset;
    }

    /**
     * Method to return the View Holder for a selected item in the Recycler View.
     * @param viewGroup The Parent View of this view object.
     * @param i Index of the item in the Recycler View.
     * @return A View Holder corresponding to the item in the given index in the Recycler View.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.weather_entry_view, viewGroup, false);

        ViewHolder holder = new ViewHolder((TextView)view);
        return holder;
    }

    /**
     * Method to change the properties of the selected view in the Recycler View.
     * @param viewHolder The Parent View of this view object.
     * @param i Index of the item in the Adapter dataset.
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTextView.setText(weatherEntryDataset.get(i).toString());
    }

    /**
     * Returns the size of the Adapter's dataset.
     * @return Size of the adapter's dataset.
     */
    @Override
    public int getItemCount() {
        return weatherEntryDataset.size();
    }

    /**
     * Class to hold the View properties of the item in the Recycler View.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(TextView textView) {
            super(textView);
            mTextView = textView;
        }
    }
}
