package com.sonu.sampleapp.network;

import com.sonu.sampleapp.pojo.MovieList;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MovieApiCalls
{

     @GET("marvel")
     Single<List<MovieList>> getMovieList();

}
