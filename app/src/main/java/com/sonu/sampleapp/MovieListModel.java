package com.sonu.sampleapp;

import android.content.Context;

import com.sonu.sampleapp.network.MovieApiCalls;
import com.sonu.sampleapp.network.MovieListRestServices;
import com.sonu.sampleapp.pojo.MovieList;

import java.util.List;

import io.reactivex.Single;

public class MovieListModel implements MovieMainContractor.Model {
    private MovieApiCalls movieApiCalls;
    private Context context;

    public MovieListModel(Context activity) {
        this.context = activity;
        movieApiCalls = MovieListRestServices.getData().create(MovieApiCalls.class);

    }

    @Override
    public Single<List<MovieList>> getMovieList() {
        return movieApiCalls.getMovieList();
    }
}
