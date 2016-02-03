package com.millennialmedia.android;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.lang.ref.WeakReference;

class BridgeMMMedia$Audio$2
        extends BridgeMMMedia.Audio.OnLoadCompleteListener {
    BridgeMMMedia$Audio$2(BridgeMMMedia.Audio paramAudio, SoundPool paramSoundPool) {
        super(paramAudio, paramSoundPool);
    }

    public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2) {
        if (paramSoundPool != null) {
        }
        try {
            Object localObject = (Context) BridgeMMMedia.Audio.b(this.a).get();
            if (localObject != null) {
                localObject = (AudioManager) ((Context) localObject).getSystemService("audio");
                float f = (((AudioManager) localObject).getStreamVolume(3) + 0.0F) / ((AudioManager) localObject).getStreamMaxVolume(3);
                paramSoundPool.play(paramInt1, f, f, 1, 0, 1.0F);
            }
            return;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$Audio$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */