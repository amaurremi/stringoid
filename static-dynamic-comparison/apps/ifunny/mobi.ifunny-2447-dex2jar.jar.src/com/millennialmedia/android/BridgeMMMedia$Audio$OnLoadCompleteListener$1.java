package com.millennialmedia.android;

import android.media.SoundPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

class BridgeMMMedia$Audio$OnLoadCompleteListener$1
        extends TimerTask {
    BridgeMMMedia$Audio$OnLoadCompleteListener$1(BridgeMMMedia.Audio.OnLoadCompleteListener paramOnLoadCompleteListener) {
    }

    public void run() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = BridgeMMMedia.Audio.OnLoadCompleteListener.a(this.a).iterator();
        while (localIterator.hasNext()) {
            Integer localInteger = (Integer) localIterator.next();
            int i = BridgeMMMedia.Audio.OnLoadCompleteListener.b(this.a).play(localInteger.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
            if (i != 0) {
                BridgeMMMedia.Audio.OnLoadCompleteListener.b(this.a).stop(i);
                this.a.onLoadComplete(BridgeMMMedia.Audio.OnLoadCompleteListener.b(this.a), localInteger.intValue(), 0);
                localArrayList.add(localInteger);
            }
        }
        BridgeMMMedia.Audio.OnLoadCompleteListener.a(this.a).removeAll(localArrayList);
        if (BridgeMMMedia.Audio.OnLoadCompleteListener.a(this.a).size() == 0) {
            BridgeMMMedia.Audio.OnLoadCompleteListener.c(this.a).cancel();
            BridgeMMMedia.Audio.OnLoadCompleteListener.c(this.a).purge();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$Audio$OnLoadCompleteListener$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */