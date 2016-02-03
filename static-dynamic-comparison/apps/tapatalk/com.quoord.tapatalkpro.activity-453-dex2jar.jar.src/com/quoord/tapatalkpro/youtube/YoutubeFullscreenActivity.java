package com.quoord.tapatalkpro.youtube;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.quoord.tapatalkpro.TapatalkApp;

public class YoutubeFullscreenActivity
        extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {
    private static final int PORTRAIT_ORIENTATION;
    public YouTubePlayer player;
    public YouTubePlayerView playerView;
    private String youtubeId;
    private String youtubeUrl;

    static {
        if (Build.VERSION.SDK_INT < 9) {
        }
        for (int i = 1; ; i = 7) {
            PORTRAIT_ORIENTATION = i;
            return;
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903445);
        getActionBar().setIcon(2130837525);
        this.youtubeId = getIntent().getStringExtra("youtube_url");
        this.youtubeUrl = getIntent().getStringExtra("url");
        this.playerView = ((YouTubePlayerView) findViewById(2131231751));
        try {
            if (getResources().getBoolean(2131558409)) {
                this.playerView.initialize(TapatalkApp.google_api_key_for_free, this);
                return;
            }
            this.playerView.initialize(TapatalkApp.google_api_key_for_pro, this);
            return;
        } catch (Exception paramBundle) {
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.player != null) {
            this.player.release();
        }
    }

    public void onInitializationFailure(YouTubePlayer.Provider paramProvider, YouTubeInitializationResult paramYouTubeInitializationResult) {
        try {
            paramProvider = new Intent("android.intent.action.VIEW");
            paramProvider.setData(Uri.parse(this.youtubeUrl));
            startActivity(paramProvider);
            finish();
            return;
        } catch (Exception paramProvider) {
            finish();
        }
    }

    public void onInitializationSuccess(YouTubePlayer.Provider paramProvider, YouTubePlayer paramYouTubePlayer, boolean paramBoolean) {
        try {
            this.player = paramYouTubePlayer;
            if (this.player != null) {
                this.player.setFullscreen(true);
                this.player.loadVideo(this.youtubeId);
            }
            return;
        } catch (Exception paramProvider) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/youtube/YoutubeFullscreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */