package com.example.earthquakeandroidsupport;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.earthquakeandroidsupport.databinding.ListItemEarthquakeBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {

    private static final SimpleDateFormat TIME_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);
    private static final NumberFormat MAGNITUDE_FORMAT =
            new DecimalFormat("0.0");

    private final List<Earthquake> mEarthquakes;

    public EarthquakeRecyclerViewAdapter(List<Earthquake> earthquakes ) {
        mEarthquakes = earthquakes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemEarthquakeBinding binding = ListItemEarthquakeBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

   /* @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_earthquake,
                        parent, false);
        return new ViewHolder(view);
    }*/
    /*@Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.earthquake = mEarthquakes.get(position);
        holder.detailsView.setText(mEarthquakes.get(position).toString());
    }*/

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Earthquake earthquake = mEarthquakes.get(position);
        holder.binding.setEarthquake(earthquake);
        holder.binding.executePendingBindings();
    }

  /*  @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Earthquake earthquake = mEarthquakes.get(position);
        holder.date.setText(TIME_FORMAT.format(earthquake.getDate()));
        holder.details.setText(earthquake.getDetails());
        holder.magnitude.setText(MAGNITUDE_FORMAT.format(earthquake.getMagnitude()));
    }*/

    @Override
    public int getItemCount() {
        return mEarthquakes.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ListItemEarthquakeBinding binding;
        public ViewHolder(ListItemEarthquakeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setTimeformat(TIME_FORMAT);
            binding.setMagnitudeformat(MAGNITUDE_FORMAT);
        }
       /* public final TextView date;
        public final TextView details;
        public final TextView magnitude;

        public ViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            details = (TextView) view.findViewById(R.id.details);
            magnitude = (TextView) view.findViewById(R.id.magnitude);
        }*/

       /* @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText() + "'";
        }*/
        /*public final View parentView;
        public final TextView detailsView;
        public Earthquake earthquake;*/


       /* public ViewHolder(View view) {
            super(view);
            parentView = view;
            detailsView = (TextView)  view.findViewById(R.id.list_item_earthquake_details);
        }*/
    }

}
