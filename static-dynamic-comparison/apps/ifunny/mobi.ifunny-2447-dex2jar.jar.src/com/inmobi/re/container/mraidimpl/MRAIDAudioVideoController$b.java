package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.controller.JSController.PlayerProperties;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayerListener;

class MRAIDAudioVideoController$b
        implements AVPlayerListener {
    MRAIDAudioVideoController$b(MRAIDAudioVideoController paramMRAIDAudioVideoController, JSController.PlayerProperties paramPlayerProperties) {
    }

    public void onComplete(AVPlayer paramAVPlayer) {
        try {
            ViewGroup localViewGroup;
            if (this.a.isFullScreen()) {
                localViewGroup = (ViewGroup) paramAVPlayer.getBackGroundLayout().getParent();
                if (localViewGroup != null) {
                    localViewGroup.removeView(paramAVPlayer.getBackGroundLayout());
                }
            } else {
                localViewGroup = (ViewGroup) paramAVPlayer.getParent();
                if (localViewGroup != null) {
                    localViewGroup.removeView(paramAVPlayer);
                    return;
                }
            }
        } catch (Exception paramAVPlayer) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Problem removing the audio relativelayout", paramAVPlayer);
        }
    }

    public void onError(AVPlayer paramAVPlayer) {
        onComplete(paramAVPlayer);
    }

    public void onPrepared(AVPlayer paramAVPlayer) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */