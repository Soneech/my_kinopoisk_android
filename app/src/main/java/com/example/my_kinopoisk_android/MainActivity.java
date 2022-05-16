package com.example.my_kinopoisk_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.my_kinopoisk_android.databinding.ActivityMainBinding;
import com.example.my_kinopoisk_android.fragments.FragmentActions;
import com.example.my_kinopoisk_android.fragments.MoviesListFragment;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity implements FragmentActions {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ActionBar actionBar;
    private String backStack = "Back";

    private Movie movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
        openFragment(new MoviesListFragment(movies));
    }

    public FragmentTransaction createFragmentTransaction() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(backStack);
        return fragmentTransaction;
    }

    @Override
    public void openFragment(Fragment fragment) {
        createFragmentTransaction()
                .replace(R.id.fragmentBody, fragment)
                .commit();
    }

    @Override
    public void setDisplayHomeVisibility(boolean status) {
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(status);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                fragmentManager.popBackStack();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Movie> {
        @Override
        protected Movie doInBackground(Void... params) {
            try {
                final String url = "http://10.0.2.2:8082/movies/0";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                movies = restTemplate.getForObject(url, Movie.class);
                return movies;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }
    }
}