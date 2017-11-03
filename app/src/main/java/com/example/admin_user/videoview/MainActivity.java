package com.example.admin_user.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements View.OnClickListener {
    YouTubePlayerView mYouTubePlayer;
    Button mYouTubeBut;
    YouTubePlayer.OnInitializedListener mYouTubeInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYouTubeBut = findViewById(R.id.button);
        mYouTubePlayer = findViewById(R.id.you_tube_play);

        mYouTubeInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("mLog" , "Initialize successful");
                youTubePlayer.loadVideo("VriiDn676PQ");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("mLog" , "Initialize is failure");
            }
        };

        mYouTubeBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("mLog" , "Initialize is starting");
        try{
            mYouTubePlayer.initialize(YouTubeConfig.getApiKey() , mYouTubeInitializedListener);
        }catch (Throwable t){
            Log.d("mLog" ,"Exception" + t.getMessage());
        }

    }
}
