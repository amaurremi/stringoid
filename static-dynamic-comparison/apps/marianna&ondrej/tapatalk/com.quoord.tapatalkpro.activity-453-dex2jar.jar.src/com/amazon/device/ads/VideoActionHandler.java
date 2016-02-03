package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class VideoActionHandler
        implements IAdActivityAdapter {
    private Activity activity;
    private RelativeLayout layout;
    private AdVideoPlayer player;

    private void initPlayer(Bundle paramBundle) {
        Controller.PlayerProperties localPlayerProperties = (Controller.PlayerProperties) paramBundle.getParcelable("player_properties");
        Controller.Dimensions localDimensions = (Controller.Dimensions) paramBundle.getParcelable("player_dimensions");
        this.player = new AdVideoPlayer(this.activity);
        this.player.setPlayData(localPlayerProperties, paramBundle.getString("url"));
        if (localDimensions == null) {
            paramBundle = new RelativeLayout.LayoutParams(-1, -1);
            paramBundle.addRule(13);
        }
        for (; ; ) {
            this.player.setLayoutParams(paramBundle);
            this.player.setViewGroup(this.layout);
            setPlayerListener(this.player);
            return;
            paramBundle = new RelativeLayout.LayoutParams(localDimensions.width, localDimensions.height);
            paramBundle.topMargin = localDimensions.y;
            paramBundle.leftMargin = localDimensions.x;
        }
    }

    private void setPlayerListener(AdVideoPlayer paramAdVideoPlayer) {
        paramAdVideoPlayer.setListener(new AdVideoPlayer.AdVideoPlayerListener() {
            public void onComplete() {
                VideoActionHandler.this.activity.finish();
            }

            public void onError() {
                VideoActionHandler.this.activity.finish();
            }
        });
    }

    public void onCreate() {
        Bundle localBundle = this.activity.getIntent().getExtras();
        this.layout = new RelativeLayout(this.activity);
        this.layout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.activity.setContentView(this.layout);
        initPlayer(localBundle);
        this.player.playVideo();
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStop() {
        this.player.releasePlayer();
        this.player = null;
        this.activity.finish();
    }

    public void preOnCreate() {
    }

    public void setActivity(Activity paramActivity) {
        this.activity = paramActivity;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/VideoActionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */