package com.lutfizone.moviesion.api;

import com.lutfizone.moviesion.BuildConfig;
import com.lutfizone.moviesion.model.MovieResponse;
import com.lutfizone.moviesion.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientService {
    @GET("movie/now_playing?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    Call<MovieResponse> getMovie();

    @GET("tv/on_the_air?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    Call<TvShowResponse> getTvShow();
}
