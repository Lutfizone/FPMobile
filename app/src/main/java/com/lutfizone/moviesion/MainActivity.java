package com.lutfizone.moviesion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.lutfizone.moviesion.ui.FavoriteFragment;
import com.lutfizone.moviesion.ui.SettingFragment;
import com.lutfizone.moviesion.ui.movie.MovieFragment;
import com.lutfizone.moviesion.ui.tvshow.TvShowFragment;

public class MainActivity extends AppCompatActivity {

    BubbleNavigationConstraintView buble;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // kita set default nya Home Fragment
        if (savedInstanceState == null) {
            loadFragment(new MovieFragment());
        }

        buble = findViewById(R.id.floating_top_bar_navigation);
        buble.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (view.getId()) {
                    case R.id.movie:
                        fragment = new MovieFragment();
                        break;
                    case R.id.tvShow:
                        fragment = new TvShowFragment();
                        break;
                    case R.id.favorite:
                        fragment = new FavoriteFragment();
                        break;
                    case R.id.setting:
                        fragment = new SettingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            }
        });
    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
