package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.internal.ac;

public class YouTubePlayerSupportFragment
        extends Fragment
        implements YouTubePlayer.Provider {
    private final a a = new a((byte) 0);
    private Bundle b;
    private YouTubePlayerView c;
    private String d;
    private YouTubePlayer.OnInitializedListener e;

    private void a() {
        if ((this.c != null) && (this.e != null)) {
            this.c.a(getActivity(), this, this.d, this.e, this.b);
            this.b = null;
            this.e = null;
        }
    }

    public static YouTubePlayerSupportFragment newInstance() {
        return new YouTubePlayerSupportFragment();
    }

    public void initialize(String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener) {
        this.d = ac.a(paramString, "Developer key cannot be null or empty");
        this.e = paramOnInitializedListener;
        a();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
        }
        for (paramBundle = paramBundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE"); ; paramBundle = null) {
            this.b = paramBundle;
            return;
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.c = new YouTubePlayerView(getActivity(), null, 0, this.a);
        a();
        return this.c;
    }

    public void onDestroy() {
        YouTubePlayerView localYouTubePlayerView;
        if (this.c != null) {
            FragmentActivity localFragmentActivity = getActivity();
            localYouTubePlayerView = this.c;
            if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
                break label40;
            }
        }
        label40:
        for (boolean bool = true; ; bool = false) {
            localYouTubePlayerView.a(bool);
            super.onDestroy();
            return;
        }
    }

    public void onDestroyView() {
        this.c.b(getActivity().isFinishing());
        this.c = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.c.c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.c.b();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        if (this.c != null) {
        }
        for (Bundle localBundle = this.c.e(); ; localBundle = this.b) {
            paramBundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", localBundle);
            return;
        }
    }

    public void onStart() {
        super.onStart();
        this.c.a();
    }

    public void onStop() {
        this.c.d();
        super.onStop();
    }

    private final class a
            implements YouTubePlayerView.b {
        private a() {
        }

        public final void a(YouTubePlayerView paramYouTubePlayerView) {
        }

        public final void a(YouTubePlayerView paramYouTubePlayerView, String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener) {
            YouTubePlayerSupportFragment.this.initialize(paramString, YouTubePlayerSupportFragment.a(YouTubePlayerSupportFragment.this));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/YouTubePlayerSupportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */