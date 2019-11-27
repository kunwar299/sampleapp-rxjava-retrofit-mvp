package com.sonu.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sonu.sampleapp.pojo.MovieList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieMainContractor.View{

    private RecyclerView movieList_Rv;
    private List<MovieList> movieLists;
    private MovieMainContractor.Model movieListModel;
    private MovieMainContractor.Presenter movieListPresentator;
    private MainActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);

        movieListModel = new MovieListModel(activity);
        movieListPresentator = new MovieListPresenter(movieListModel,activity);
        movieListPresentator.initView();
        movieListPresentator.getMovieListData();
    }

    @Override
    public void onInitView() {

        movieList_Rv = findViewById(R.id.recyclerView);
        movieLists = new ArrayList<>();

    }

    @Override
    public void setMovieList_Rv(List<MovieList> movieLists) {

        movieList_Rv.setLayoutManager(new LinearLayoutManager(this));
        movieList_Rv.setAdapter(new MovieListAdapter(movieLists,this));
        movieList_Rv.getAdapter().notifyDataSetChanged();

    }
}
