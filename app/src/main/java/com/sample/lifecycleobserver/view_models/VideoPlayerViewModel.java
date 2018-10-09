package com.sample.lifecycleobserver.view_models;

import android.arch.lifecycle.ViewModel;

public class VideoPlayerViewModel extends ViewModel {
    private int videoPlayedSeconds;

    public int getVideoPlayedSeconds() {
        return videoPlayedSeconds;
    }

    public void setVideoPlayedSeconds(int videoPlayedSeconds) {
        this.videoPlayedSeconds = videoPlayedSeconds;
    }
}