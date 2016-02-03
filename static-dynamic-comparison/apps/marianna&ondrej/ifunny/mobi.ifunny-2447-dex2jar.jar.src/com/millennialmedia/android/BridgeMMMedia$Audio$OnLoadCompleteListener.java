package com.millennialmedia.android;

import android.media.SoundPool;

import java.util.ArrayList;
import java.util.Timer;

abstract class BridgeMMMedia$Audio$OnLoadCompleteListener {
    private ArrayList<Integer> a = new ArrayList();
    private Timer c;
    private SoundPool d;

    public BridgeMMMedia$Audio$OnLoadCompleteListener(BridgeMMMedia.Audio paramAudio, SoundPool paramSoundPool) {
        this.d = paramSoundPool;
    }

    void a() {
        try {
            if (this.c != null) {
                this.c.cancel();
                this.c.purge();
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    void a(int paramInt) {
        try {
            this.a.add(Integer.valueOf(paramInt));
            if (this.a.size() == 1) {
                this.c = new Timer();
                this.c.scheduleAtFixedRate(new BridgeMMMedia.Audio.OnLoadCompleteListener .1 (this), 0L, 100L);
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    abstract void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */