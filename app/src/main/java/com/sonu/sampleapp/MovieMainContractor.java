package com.sonu.sampleapp;

import com.sonu.sampleapp.pojo.MovieList;

import java.util.List;

import io.reactivex.Single;

public interface MovieMainContractor {
    interface View {

        void onInitView();
        void setMovieList_Rv(List<MovieList> movieLists);

    }

    interface Presenter {

        void initView();
        void getMovieListData();

    }

    interface Model {

        Single<List<MovieList>> getMovieList();

    }


}
