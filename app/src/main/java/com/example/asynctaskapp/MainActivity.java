package com.example.asynctaskapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mProgressBar.incrementProgressBy(5);
        };
    };

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
        /*Intent  mIntent = new Intent(this,MainActivity.class);
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);*/

       /* if(!downloadTask.isCancelled()){
            downloadTask.cancel(true);
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProgressBar.setProgress(0);

       /* Thread myThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i=0;i<20;i++){
                        Thread.sleep(100);
                        handler.sendMessage(handler.obtainMessage());
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        myThread.start();*/
    }
}
