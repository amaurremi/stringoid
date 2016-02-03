package com.inmobi.re.controller.util;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

class AVPlayer$c
        extends Handler {
    private final WeakReference<AVPlayer> a;

    public AVPlayer$c(AVPlayer paramAVPlayer) {
        this.a = new WeakReference(paramAVPlayer);
    }

    public void handleMessage(Message paramMessage) {
        AVPlayer localAVPlayer = (AVPlayer) this.a.get();
        if (localAVPlayer != null) {
            switch (paramMessage.what) {
            }
        }
        for (; ; ) {
            super.handleMessage(paramMessage);
            do {
                return;
            } while (!AVPlayer.a(localAVPlayer));
            int i = Math.round(localAVPlayer.getCurrentPosition() / 1000);
            int j = Math.round(localAVPlayer.getDuration() / 1000);
            if (AVPlayer.b(localAVPlayer) != i) {
                AVPlayer.a(localAVPlayer, i, j);
                AVPlayer.a(localAVPlayer, i);
                AVPlayer.b(localAVPlayer, i);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/util/AVPlayer$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */