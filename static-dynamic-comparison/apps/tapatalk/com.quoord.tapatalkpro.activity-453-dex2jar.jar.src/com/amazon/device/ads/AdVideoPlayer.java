package com.amazon.device.ads;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;

final class AdVideoPlayer
        implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private static String LOG_TAG = "AdVideoPlayer";
    private AudioManager audioManager_;
    private String contentUrl_;
    private Context context_;
    private ViewGroup.LayoutParams layoutParams_ = null;
    private AdVideoPlayerListener listener_;
    private Controller.PlayerProperties playerProperties_;
    private boolean released_ = false;
    private VideoView videoView_ = null;
    private ViewGroup viewGroup_ = null;
    private int volumeBeforeMuting_;

    public AdVideoPlayer(Context paramContext) {
        this.context_ = paramContext;
        this.playerProperties_ = new Controller.PlayerProperties();
        this.audioManager_ = ((AudioManager) this.context_.getSystemService("audio"));
    }

    private void displayPlayerControls() {
        Log.d(LOG_TAG, "in displayPlayerControls");
        if (this.playerProperties_.showControl()) {
            MediaController localMediaController = new MediaController(this.context_);
            this.videoView_.setMediaController(localMediaController);
            localMediaController.setAnchorView(this.videoView_);
            localMediaController.requestFocus();
        }
    }

    private void initializeVideoView() {
        VideoView localVideoView = new VideoView(this.context_);
        localVideoView.setOnCompletionListener(this);
        localVideoView.setOnErrorListener(this);
        localVideoView.setLayoutParams(this.layoutParams_);
        this.videoView_ = localVideoView;
        this.viewGroup_.addView(this.videoView_);
    }

    private void loadPlayerContent() {
        Uri localUri = Uri.parse(this.contentUrl_);
        this.videoView_.setVideoURI(localUri);
    }

    private void removePlayerFromParent() {
        Log.d(LOG_TAG, "in removePlayerFromParent");
        this.viewGroup_.removeView(this.videoView_);
    }

    public void mutePlayer() {
        Log.d(LOG_TAG, "in mutePlayer");
        this.volumeBeforeMuting_ = this.audioManager_.getStreamVolume(3);
        this.audioManager_.setStreamVolume(3, 0, 4);
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        if (this.playerProperties_.doLoop()) {
            this.videoView_.start();
        }
        do {
            do {
                return;
            } while ((!this.playerProperties_.exitOnComplete()) && (!this.playerProperties_.inline));
            releasePlayer();
        } while (this.listener_ == null);
        this.listener_.onComplete();
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        removePlayerFromParent();
        if (this.listener_ != null) {
            this.listener_.onError();
        }
        return false;
    }

    public void playAudio() {
        Log.d(LOG_TAG, "in playAudio");
        loadPlayerContent();
    }

    public void playVideo() {
        Log.d(LOG_TAG, "in playVideo");
        if (this.playerProperties_.doMute()) {
            mutePlayer();
        }
        initializeVideoView();
        loadPlayerContent();
        startPlaying();
    }

    public void releasePlayer() {
        Log.d(LOG_TAG, "in releasePlayer");
        if (this.released_) {
        }
        do {
            return;
            this.released_ = true;
            this.videoView_.stopPlayback();
            removePlayerFromParent();
        } while (!this.playerProperties_.doMute());
        unmutePlayer();
    }

    public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        this.layoutParams_ = paramLayoutParams;
    }

    public void setListener(AdVideoPlayerListener paramAdVideoPlayerListener) {
        this.listener_ = paramAdVideoPlayerListener;
    }

    public void setPlayData(Controller.PlayerProperties paramPlayerProperties, String paramString) {
        this.released_ = false;
        if (paramPlayerProperties != null) {
            this.playerProperties_ = paramPlayerProperties;
        }
        this.contentUrl_ = paramString;
    }

    public void setViewGroup(ViewGroup paramViewGroup) {
        this.viewGroup_ = paramViewGroup;
    }

    public void startPlaying() {
        Log.d(LOG_TAG, "in startPlaying");
        displayPlayerControls();
        if (this.playerProperties_.isAutoPlay()) {
            this.videoView_.start();
        }
    }

    public void unmutePlayer() {
        Log.d(LOG_TAG, "in unmutePlayer");
        this.audioManager_.setStreamVolume(3, this.volumeBeforeMuting_, 4);
    }

    public static abstract interface AdVideoPlayerListener {
        public abstract void onComplete();

        public abstract void onError();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdVideoPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */