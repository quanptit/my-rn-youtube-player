package com.app.youtube.player;

import com.facebook.react.bridge.*;

public class RNYoutubeVideoMoudule extends ReactContextBaseJavaModule {

    public RNYoutubeVideoMoudule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNYoutubeVideoMoudule";
    }

    @ReactMethod
    public void openFullScreenYotubeVideo(String videoId, String YOUTUBE_KEY) {
        if (getCurrentActivity() == null) return;
        YoutubeUtils.openFullScreenYotubeVideo(getCurrentActivity(), videoId, YOUTUBE_KEY);
    }


}
