package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.HttpClient;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

class VastVideoViewController$6
        implements MediaPlayer.OnCompletionListener {
    VastVideoViewController$6(VastVideoViewController paramVastVideoViewController, Context paramContext, VideoView paramVideoView) {
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        VastVideoViewController.access$1700(this.this$0);
        VastVideoViewController.access$1300(this.this$0);
        this.this$0.videoCompleted(false);
        HttpClient.makeTrackingHttpRequest(VastVideoViewController.access$100(this.this$0).getCompleteTrackers(), this.val$context);
        VastVideoViewController.access$1802(this.this$0, true);
        this.val$videoView.setVisibility(8);
        if (VastVideoViewController.access$1900(this.this$0).getDrawable() != null) {
            VastVideoViewController.access$1900(this.this$0).setVisibility(0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */