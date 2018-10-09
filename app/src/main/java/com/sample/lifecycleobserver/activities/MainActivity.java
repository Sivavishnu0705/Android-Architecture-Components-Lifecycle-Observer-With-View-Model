package com.sample.lifecycleobserver.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sample.lifecycleobserver.R;
import com.sample.lifecycleobserver.view_models.VideoPlayerViewModel;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private VideoPlayerViewModel videoPlayerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPlayerViewModel = ViewModelProviders.of(this).get(VideoPlayerViewModel.class);

        videoView = findViewById(R.id.vv_video);
        final MediaController mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        videoView.setMediaController(mediacontroller);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.android_lifecycle_aware_components_android_architecture));
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.start();
        videoView.seekTo(videoPlayerViewModel.getVideoPlayedSeconds());

    }

    @Override
    protected void onPause() {
        super.onPause();
        videoPlayerViewModel.setVideoPlayedSeconds(videoView.getCurrentPosition());
    }
}