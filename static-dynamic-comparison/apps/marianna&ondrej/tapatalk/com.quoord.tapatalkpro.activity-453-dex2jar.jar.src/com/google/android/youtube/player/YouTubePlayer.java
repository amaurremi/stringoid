package com.google.android.youtube.player;

import java.util.List;

public abstract interface YouTubePlayer {
    public static final int FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE = 4;
    public static final int FULLSCREEN_FLAG_CONTROL_ORIENTATION = 1;
    public static final int FULLSCREEN_FLAG_CONTROL_SYSTEM_UI = 2;
    public static final int FULLSCREEN_FLAG_CUSTOM_LAYOUT = 8;

    public abstract void addFullscreenControlFlag(int paramInt);

    public abstract void cuePlaylist(String paramString);

    public abstract void cuePlaylist(String paramString, int paramInt1, int paramInt2);

    public abstract void cueVideo(String paramString);

    public abstract void cueVideo(String paramString, int paramInt);

    public abstract void cueVideos(List<String> paramList);

    public abstract void cueVideos(List<String> paramList, int paramInt1, int paramInt2);

    public abstract int getCurrentTimeMillis();

    public abstract int getDurationMillis();

    public abstract int getFullscreenControlFlags();

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();

    public abstract boolean isPlaying();

    public abstract void loadPlaylist(String paramString);

    public abstract void loadPlaylist(String paramString, int paramInt1, int paramInt2);

    public abstract void loadVideo(String paramString);

    public abstract void loadVideo(String paramString, int paramInt);

    public abstract void loadVideos(List<String> paramList);

    public abstract void loadVideos(List<String> paramList, int paramInt1, int paramInt2);

    public abstract void next();

    public abstract void pause();

    public abstract void play();

    public abstract void previous();

    public abstract void release();

    public abstract void seekRelativeMillis(int paramInt);

    public abstract void seekToMillis(int paramInt);

    public abstract void setFullscreen(boolean paramBoolean);

    public abstract void setFullscreenControlFlags(int paramInt);

    public abstract void setManageAudioFocus(boolean paramBoolean);

    public abstract void setOnFullscreenListener(OnFullscreenListener paramOnFullscreenListener);

    public abstract void setPlaybackEventListener(PlaybackEventListener paramPlaybackEventListener);

    public abstract void setPlayerStateChangeListener(PlayerStateChangeListener paramPlayerStateChangeListener);

    public abstract void setPlayerStyle(PlayerStyle paramPlayerStyle);

    public abstract void setPlaylistEventListener(PlaylistEventListener paramPlaylistEventListener);

    public abstract void setShowFullscreenButton(boolean paramBoolean);

    public static enum ErrorReason {
        static {
            BLOCKED_FOR_APP = new ErrorReason("BLOCKED_FOR_APP", 1);
            NOT_PLAYABLE = new ErrorReason("NOT_PLAYABLE", 2);
            NETWORK_ERROR = new ErrorReason("NETWORK_ERROR", 3);
            UNAUTHORIZED_OVERLAY = new ErrorReason("UNAUTHORIZED_OVERLAY", 4);
            PLAYER_VIEW_TOO_SMALL = new ErrorReason("PLAYER_VIEW_TOO_SMALL", 5);
            EMPTY_PLAYLIST = new ErrorReason("EMPTY_PLAYLIST", 6);
            AUTOPLAY_DISABLED = new ErrorReason("AUTOPLAY_DISABLED", 7);
            USER_DECLINED_RESTRICTED_CONTENT = new ErrorReason("USER_DECLINED_RESTRICTED_CONTENT", 8);
            USER_DECLINED_HIGH_BANDWIDTH = new ErrorReason("USER_DECLINED_HIGH_BANDWIDTH", 9);
            UNEXPECTED_SERVICE_DISCONNECTION = new ErrorReason("UNEXPECTED_SERVICE_DISCONNECTION", 10);
        }

        private ErrorReason() {
        }
    }

    public static abstract interface OnFullscreenListener {
        public abstract void onFullscreen(boolean paramBoolean);
    }

    public static abstract interface OnInitializedListener {
        public abstract void onInitializationFailure(YouTubePlayer.Provider paramProvider, YouTubeInitializationResult paramYouTubeInitializationResult);

        public abstract void onInitializationSuccess(YouTubePlayer.Provider paramProvider, YouTubePlayer paramYouTubePlayer, boolean paramBoolean);
    }

    public static abstract interface PlaybackEventListener {
        public abstract void onBuffering(boolean paramBoolean);

        public abstract void onPaused();

        public abstract void onPlaying();

        public abstract void onSeekTo(int paramInt);

        public abstract void onStopped();
    }

    public static abstract interface PlayerStateChangeListener {
        public abstract void onAdStarted();

        public abstract void onError(YouTubePlayer.ErrorReason paramErrorReason);

        public abstract void onLoaded(String paramString);

        public abstract void onLoading();

        public abstract void onVideoEnded();

        public abstract void onVideoStarted();
    }

    public static enum PlayerStyle {
        private PlayerStyle() {
        }
    }

    public static abstract interface PlaylistEventListener {
        public abstract void onNext();

        public abstract void onPlaylistEnded();

        public abstract void onPrevious();
    }

    public static abstract interface Provider {
        public abstract void initialize(String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/YouTubePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */