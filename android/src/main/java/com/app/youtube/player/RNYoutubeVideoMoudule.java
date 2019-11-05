package com.app.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

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
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
            intent.putExtra("VIDEO_ID", videoId);
            startNewPlay(getReactApplicationContext(), intent);
        } catch (Exception e) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=" + videoId));
            startNewPlay(getReactApplicationContext(), intent);
        }
    }
    private static void startNewPlay(Context context, Intent intent){
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("force_fullscreen", true);
        context.startActivity(intent);
    }


}
