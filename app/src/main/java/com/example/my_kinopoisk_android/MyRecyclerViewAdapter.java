package com.example.my_kinopoisk_android;

import  android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.my_kinopoisk_android.models.Movie;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Movie> movies;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    MyRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.inflater = LayoutInflater.from(context);
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String movieTitle = movies.get(position).getTitle();
        String ageLimit = String.valueOf(movies.get(position).getAgeLimit()) + "+";
        String countryOfProduction = movies.get(position).getCountryOfProduction();
        holder.movieTitleTV.setText(movieTitle);
        holder.ageLimitTV.setText(ageLimit);
        holder.countryOfProductionTV.setText(countryOfProduction);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView movieTitleTV;
        TextView ageLimitTV;
        TextView countryOfProductionTV;

        ViewHolder(View itemView) {
            super(itemView);
            movieTitleTV = itemView.findViewById(R.id.movieTitleTextView);
            ageLimitTV = itemView.findViewById(R.id.ageLimitTextView);
            countryOfProductionTV = itemView.findViewById(R.id.countryOfProductionTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, getItem(getAdapterPosition()));
        }
    }

    Movie getItem(int id) {
        return movies.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, Movie movie);
    }
}