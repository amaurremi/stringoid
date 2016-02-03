package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayerListener;

class MRAIDAudioVideoController$c
        implements AVPlayerListener {
    MRAIDAudioVideoController$c(MRAIDAudioVideoController paramMRAIDAudioVideoController) {
    }

    public void onComplete(AVPlayer paramAVPlayer) {
        MRAIDAudioVideoController.a(this.a).setBusy(false);
        try {
            ViewGroup localViewGroup = paramAVPlayer.getBackGroundLayout();
            if (localViewGroup != null) {
                ((ViewGroup) localViewGroup.getParent()).removeView(paramAVPlayer.getBackGroundLayout());
            }
            paramAVPlayer.setBackGroundLayout(null);
        } catch (Exception localException) {
            for (; ; ) {
                try {
                    if ((this.a.videoPlayer != null) && (paramAVPlayer.getPropertyID().equalsIgnoreCase(this.a.videoPlayer.getPropertyID()))) {
                        this.a.videoPlayer = null;
                    }
                    return;
                } finally {
                }
                localException = localException;
                Log.debug("[InMobi]-[RE]-4.5.1", "Problem removing the video framelayout or relativelayout depending on video startstyle", localException);
            }
        }
    }

    public void onError(AVPlayer paramAVPlayer) {
        onComplete(paramAVPlayer);
    }

    public void onPrepared(AVPlayer paramAVPlayer) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */