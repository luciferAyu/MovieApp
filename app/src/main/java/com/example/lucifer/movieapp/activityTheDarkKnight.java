package com.example.lucifer.movieapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class activityTheDarkKnight extends AppCompatActivity {

    WebView webpage ;

    MediaPlayer playTheme ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_dark_knight);


        // For activity
        Intent caller = getIntent();


        // for playing music
        playTheme = MediaPlayer.create(this , R.raw.knight);



        //For WebView
        webpage = (WebView)findViewById(R.id.webView);



    }

    public void toPlay(View v){
        playTheme.start();
        Toast.makeText(this, R.string.playToast, Toast.LENGTH_SHORT).show();

    }
    public void toPause(View v){
        if(playTheme.isPlaying()){
            playTheme.pause();
            Toast.makeText(this, R.string.pauseToast, Toast.LENGTH_SHORT).show();
        }
    }

    public void toRate(View v){
        RatingBar rate = (RatingBar)findViewById(R.id.ratingBar);
        float rating = rate.getRating();
        SharedPreferences ratingPref = getSharedPreferences("RATING_PREF" ,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ratingPref.edit();

        Toast.makeText(this, getString(R.string.ratingPresentToast)+ rating + getString(R.string.ratingToast2)+ ratingPref.getFloat("ratingValueTHEDARKKNIGHT" , 0), Toast.LENGTH_SHORT).show();

        editor.putFloat("ratingValueTHEDARKKNIGHT" , rating);
        editor.commit();
    }

    public void showWebpage(View v){
        webpage.setWebViewClient(new WebViewClient());
        webpage.loadUrl(getString(R.string.webpageTheDarkKnight));
    }
}
