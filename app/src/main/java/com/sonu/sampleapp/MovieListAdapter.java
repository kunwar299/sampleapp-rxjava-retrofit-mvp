package com.sonu.sampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sonu.sampleapp.pojo.MovieList;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder>
{
    private List<MovieList>movieLists;
    private static Context context;
    public MovieListAdapter(List<MovieList>movieLists,Context context)
    {
        this.movieLists=movieLists;
        MovieListAdapter.context =context;
    }
    @NonNull
    @Override
    public MovieListAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View setMenuView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,
                parent, false);
        return new MovieHolder(setMenuView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int position) {
        movieHolder.SetMovieList(movieLists.get(position));

    }

    @Override
    public int getItemCount() {
        return movieLists.size();
    }


     static class MovieHolder extends RecyclerView.ViewHolder
   {
       private TextView name_tv,realName_tv,createdBy_tv,team_tv,publisher_tv;
       private ImageView imageUrl_iv;

       public MovieHolder(@NonNull View itemView) {
           super(itemView);
           name_tv =itemView.findViewById(R.id.name_Tv);
           realName_tv =itemView.findViewById(R.id.real_name_Tv);
           createdBy_tv = itemView.findViewById(R.id.createdby_Tv);
           team_tv = itemView.findViewById(R.id.team_Tv);
           publisher_tv = itemView.findViewById(R.id.publisher_Tv);
           imageUrl_iv = itemView.findViewById(R.id.imageUrl_Iv);

       }

         public  void SetMovieList(MovieList movieList) {

           name_tv.setText("Name :  "+movieList.getName());
           realName_tv.setText("Real Name :  "+movieList.getRealname());
           createdBy_tv.setText("CreatedBy :  "+movieList.getCreatedby());
           team_tv.setText("Team :  "+movieList.getTeam());
           publisher_tv.setText("Publisher :  "+movieList.getPublisher());
           Glide.with(context).load(movieList.getImageurl()).into(imageUrl_iv);
       }
   }
}
