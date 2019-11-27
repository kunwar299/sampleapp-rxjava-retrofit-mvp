package com.sonu.sampleapp;

import com.sonu.sampleapp.network.MovieApiCalls;
import com.sonu.sampleapp.network.MovieListRestServices;
import com.sonu.sampleapp.pojo.MovieList;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class MovieListPresenterTest {

    private MovieApiCalls movieApiCalls;

    @Before
    public void setUp() throws Exception {
        movieApiCalls = MovieListRestServices.getData().create(MovieApiCalls.class);
    }


    @Test
    public void getMovieListData() {
        TestObserver<List<MovieList>> testObserver = new TestObserver<>();
        movieApiCalls.getMovieList().subscribe(testObserver);
        testObserver.assertSubscribed();
        testObserver.assertNoErrors();
        testObserver.assertComplete();
        List<MovieList> response = testObserver.values().get(0);

        assertEquals("Captain America",response.get(0).getName());

        assertEquals("1963", response.get(1).getFirstappearance());
    }
}