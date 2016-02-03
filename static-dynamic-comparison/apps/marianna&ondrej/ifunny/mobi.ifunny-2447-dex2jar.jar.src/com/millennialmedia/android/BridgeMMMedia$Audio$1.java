package com.millennialmedia.android;

import android.media.MediaPlayer;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class BridgeMMMedia$Audio$1
        implements Runnable {
    BridgeMMMedia$Audio$1(BridgeMMMedia.Audio paramAudio) {
    }

    public void run() {
        if (BridgeMMMedia.Audio.a(this.a) != null) {
            if (BridgeMMMedia.Audio.a(this.a).isPlaying()) {
                int i = BridgeMMMedia.Audio.a(this.a).getCurrentPosition();
                if (this.a.b != null) {
                    Iterator localIterator = this.a.b.iterator();
                    while (localIterator.hasNext()) {
                        ((BridgeMMMedia.Audio.PeriodicListener) localIterator.next()).onUpdate(i);
                    }
                }
            }
            MMSDK.a(this, 500L);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$Audio$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */