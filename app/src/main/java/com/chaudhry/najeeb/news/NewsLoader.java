package com.chaudhry.najeeb.news;


import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    // Tag for log messages
    private static final String LOG_TAG = NewsLoader.class.getName();

    // Query URL
    private String mUrl;

    // Constructs a new {@link EarthquakeLoader}
    // @param context of the activity
    // @param url to load data from
    public NewsLoader(Context context) {
        super(context);
    }


    //Subclasses must implement this to take care of loading their data, as per startLoading()
    @Override
    protected void onStartLoading() {
        // This is required to trigger the loader to start doing background work
        forceLoad();   // Force an asynchronous load
    }


    @Override
    public List<News> loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
