package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;

public class YouTubeBaseActivity
        extends Activity {
    private a a;
    private YouTubePlayerView b;
    private int c;
    private Bundle d;

    final YouTubePlayerView.b a() {
        return this.a;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = new a((byte) 0);
        if (paramBundle != null) {
        }
        for (paramBundle = paramBundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE"); ; paramBundle = null) {
            this.d = paramBundle;
            return;
        }
    }

    protected void onDestroy() {
        if (this.b != null) {
            this.b.a(isFinishing());
        }
        super.onDestroy();
    }

    protected void onPause() {
        this.c = 1;
        if (this.b != null) {
            this.b.c();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.c = 2;
        if (this.b != null) {
            this.b.b();
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        if (this.b != null) {
        }
        for (Bundle localBundle = this.b.e(); ; localBundle = this.d) {
            paramBundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", localBundle);
            return;
        }
    }

    protected void onStart() {
        super.onStart();
        this.c = 1;
        if (this.b != null) {
            this.b.a();
        }
    }

    protected void onStop() {
        this.c = 0;
        if (this.b != null) {
            this.b.d();
        }
        super.onStop();
    }

    private final class a
            implements YouTubePlayerView.b {
        private a() {
        }

        public final void a(YouTubePlayerView paramYouTubePlayerView) {
            if ((YouTubeBaseActivity.c(YouTubeBaseActivity.this) != null) && (YouTubeBaseActivity.c(YouTubeBaseActivity.this) != paramYouTubePlayerView)) {
                YouTubeBaseActivity.c(YouTubeBaseActivity.this).b(true);
            }
            YouTubeBaseActivity.a(YouTubeBaseActivity.this, paramYouTubePlayerView);
            if (YouTubeBaseActivity.d(YouTubeBaseActivity.this) > 0) {
                paramYouTubePlayerView.a();
            }
            if (YouTubeBaseActivity.d(YouTubeBaseActivity.this) >= 2) {
                paramYouTubePlayerView.b();
            }
        }

        public final void a(YouTubePlayerView paramYouTubePlayerView, String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener) {
            paramYouTubePlayerView.a(YouTubeBaseActivity.this, paramYouTubePlayerView, paramString, paramOnInitializedListener, YouTubeBaseActivity.a(YouTubeBaseActivity.this));
            YouTubeBaseActivity.b(YouTubeBaseActivity.this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/YouTubeBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */