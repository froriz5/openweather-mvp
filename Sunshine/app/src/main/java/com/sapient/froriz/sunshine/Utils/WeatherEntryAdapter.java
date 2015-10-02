package com.sapient.froriz.sunshine.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
     * Hold private instance of ViewGroup's context to use in helper method below.
     */
    private Context context;

    /**
     * Constructor for initializing the adapter's dataset.
     * @param weatherEntryDataset List of Weather Entry POJOs.
     */
    public WeatherEntryAdapter(List<WeatherEntry> weatherEntryDataset) {
        this.weatherEntryDataset = weatherEntryDataset;
        notifyDataSetChanged();
    }

    /**
     * Set the dataset after a new list is created.
     * @param weatherEntryDataset List of Weather Entry POJOs.
     */
    public void setWeatherEntryDataset(List<WeatherEntry> weatherEntryDataset) {
        this.weatherEntryDataset = weatherEntryDataset;
    }

    /**
     * Override to return correct position of ViewHolder in the list. Default returns 0 everytime.
     * @param position Position in the list.
     * @return Position in the list.
     */
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /**
     * Method to return the View Holder for a selected item in the Recycler View.
     * @param viewGroup The Parent View of this view object.
     * @param i Index of the item in the Recycler View.
     * @return A View Holder corresponding to the item in the given index in the Recycler View.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == 0) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.weather_entry_first_view, viewGroup, false);
        }
        else {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.weather_entry_view, viewGroup, false);
        }

        ViewHolder holder = new ViewHolder((CardView)view);

        // Setting context to use in helper methods to access Resources (i.e. drawables).
        context = viewGroup.getContext();

        return holder;
    }

    /**
     * Method to change the properties of the selected view in the Recycler View.
     * Using separate methods for TextViews and ImageViews to better isolate for testing.
     * @param viewHolder The Parent View of this view object.
     * @param i Index of the item in the Adapter dataset.
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        setViewHolderTextProperties(viewHolder, i);
        setViewHolderImageProperties(viewHolder, i);
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
        public CardView mCardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            mCardView = cardView;
        }
    }

    /**
     * Helper method to populate the ViewHolder's fields.
     * @param holder ViewHolder holding the root of the ViewGroup.
     * @param index Index of where the ViewHolder appears on the list.
     */
    private void setViewHolderTextProperties(ViewHolder holder, int index) {
        // Case of the first item in the list should have a current temperature.
        if (index == 0) {
            ((TextView) holder.mCardView.findViewById(R.id.text_view_temp_current))
                    .setText("Current: " + weatherEntryDataset.get(index).getCurrentTemp() + "\u00b0");
        }

        ((TextView) holder.mCardView.findViewById(R.id.text_view_city_name))
                .setText(weatherEntryDataset.get(index).getLocation());
        ((TextView) holder.mCardView.findViewById(R.id.text_view_date))
                .setText(weatherEntryDataset.get(index).getFormattedDate()+"");
        ((TextView) holder.mCardView.findViewById(R.id.text_view_temp_low))
                .setText("Low: "+ weatherEntryDataset.get(index).getLow() + "\u00b0");
        ((TextView) holder.mCardView.findViewById(R.id.text_view_temp_high))
                .setText("High: " + weatherEntryDataset.get(index).getHigh() + "\u00b0");
        ((TextView) holder.mCardView.findViewById(R.id.text_view_weather_description))
                .setText(weatherEntryDataset.get(index).getDescription());
    }

    /**
     * Helper method to set the ViewHolder's ImageView Drawable.
     * @param holder ViewHolder holding the root of the ViewGroup.
     * @param index Index of where the ViewHolder appears on the list.
     */
    private void setViewHolderImageProperties(ViewHolder holder, int index) {
        String desc = weatherEntryDataset.get(index).getDescription();
        setWeatherCardIcon(holder, index, desc);
    }

    /**
     * Method to set the Image Icon of the CardView to it's corresponding description.
     * Default of Clouds if different description.
     * @param holder ViewHolder holding the root of the ViewGroup.
     * @param index Index of where the ViewHolder appears on the list.
     * @param description Description of the weather
     *                    (i.e. Clouds, Rain, Snow, Drizzle, Thunderstorm, Clear)
     */
    private void setWeatherCardIcon(ViewHolder holder, int index, String description) {
        ((ImageView) holder.mCardView.findViewById(R.id.image_view_weather_icon))
                .setImageDrawable(
                        getImageDrawable(description)
                );
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
        Drawable image = ContextCompat.getDrawable(context, imageResource);
        return image;
    }

    /**
     * Helper method to return the imageResource value to pass into the getImageResource method.
     * @param uri The path of the icon in the resources folder (i.e. @drawable/cloudy).
     * @return An int representing the resource value.
     */
    private int getImageResource(String uri) {
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        return imageResource;
    }
}
