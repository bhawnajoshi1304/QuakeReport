package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<earthquake>> {


    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
        Log.i(LOG_TAG,"EarthquakeLoader constructur called.");
    }

    @Override
    public List<earthquake> loadInBackground() {
        Log.i(LOG_TAG,"EarthquakeLoader loadInBackground() called.");
        if( mUrl == null){
            return null;
        }
        List<earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }
    @Override
    protected  void onStartLoading(){
        Log.i(LOG_TAG,"EarthquakeLoader onStartLoading called.");
        forceLoad();
    }

}
