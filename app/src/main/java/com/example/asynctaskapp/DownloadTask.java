package com.example.asynctaskapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<String ,Integer,Boolean > {
    ProgressBar progressBar;
    public static String TAG = DownloadTask.class.getSimpleName();
    Context mContext;

    public DownloadTask(MainActivity mainActivity, ProgressBar mProgressBar) {
        progressBar = mProgressBar;
        mContext = mainActivity;
    }
    //input type = url -- string
    //progress type = %downloaded -- integer
    //result type -- Boolean


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    //this method will run on the seperate bg thread
    @Override
    protected Boolean doInBackground(String... url) {
        Log.i(TAG,"url"+url[0]);
        int totalSecs = 100;
        for(int i=0; i<totalSecs;i++){
            try {
                Thread.sleep(300);
                //i += 5;  //i = i+10
                publishProgress(i); //onProgressUpdate
                //i am sending a progress[%age downloaded] to the ui thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return true;//onPostExecute
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(mContext, "download finished", Toast.LENGTH_SHORT).show();
    }
}
