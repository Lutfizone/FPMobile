package com.lutfizone.moviesion.ui.movie;

import com.lutfizone.moviesion.model.MovieItem;

import java.util.ArrayList;

public interface MovieView {
    void showLoad();

    void finishLoad();

    void showList(ArrayList<MovieItem> listMovie);

    void noData();
}
