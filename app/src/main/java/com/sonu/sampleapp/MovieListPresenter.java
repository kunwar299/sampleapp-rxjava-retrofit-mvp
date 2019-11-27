package com.sonu.sampleapp;

import com.sonu.sampleapp.pojo.MovieList;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieListPresenter implements MovieMainContractor.Presenter
{
    private MovieMainContractor.Model movieModel;
    private MovieMainContractor.View movieView;

    public  MovieListPresenter (MovieMainContractor.Model movieModel ,MovieMainContractor.View movieView)
    {
        this.movieModel = movieModel;
        this.movieView = movieView;
    }

    @Override
    public void initView() {
          movieView.onInitView();
    }

    @Override
    public void getMovieListData() {

     movieModel.getMovieList()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new SingleObserver<List<MovieList>>() {
                     @Override
                     public void onSubscribe(Disposable d) {


                     }

                     @Override
                     public void onSuccess(List<MovieList> movieLists) {
                         movieView.setMovieList_Rv(movieLists);
                     }

                     @Override
                     public void onError(Throwable e) {

                     }
                 });


    }


}
