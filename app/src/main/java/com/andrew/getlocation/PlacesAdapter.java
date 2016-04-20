package com.andrew.getlocation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

import java.util.ArrayList;

/**
 * Created by Andrew on 4/8/2016.
 */
public class PlacesAdapter extends ArrayAdapter<PlaceLikelihood> {
    private final Context context;
    private ArrayList<PlaceLikelihood> objects;

    public PlacesAdapter(Context context, int resource, int textViewResourceId, ArrayList<PlaceLikelihood> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);

        Place place = objects.get(position).getPlace();
        if (place.getPlaceTypes().contains(Place.TYPE_UNIVERSITY) || place.getPlaceTypes().contains(Place.TYPE_GAS_STATION)) {
            textView.setText(String.format("Name: %s", place.getName()));
            textView.setTextSize(30);
        }

        return textView;
    }
}
