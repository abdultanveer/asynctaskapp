package com.example.asynctaskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progressBar1);
    }

    public void handleClick(View view) {
        DownloadTask downloadTask = new DownloadTask(this,mProgressBar);
        downloadTask.execute("http://file url to download");//onPreExecute
       /* if(!downloadTask.isCancelled()){
            downloadTask.cancel(true);
        }*/
    }
}
