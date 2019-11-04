package com.app.youtube.player;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class YoutubeUtils {
    public static void openFullScreenYotubeVideo(Activity activity, String videoId, String YOUTUBE_KEY) {
        try {
            Intent intent = YouTubeStandalonePlayer.createVideoIntent(activity, YOUTUBE_KEY, videoId, 0, true, false);
            activity.startActivity(intent);
        } catch (Exception e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoId));
            activity.startActivity(intent);
        }
    }
}
