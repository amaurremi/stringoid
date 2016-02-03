package com.millennialmedia.android;

import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognizer;

class NVASpeechKit$2
        implements Runnable {
    NVASpeechKit$2(NVASpeechKit paramNVASpeechKit) {
    }

    public void run() {
        if (NVASpeechKit.a(this.a) != null) {
            double d = NVASpeechKit.AudioLevelTracker.a(NVASpeechKit.a(this.a).getAudioLevel());
            MMLog.b("NVASpeechKit", "audiolevel changed: level=" + d);
            if ((NVASpeechKit.b(this.a).update(d)) && (NVASpeechKit.c(this.a) != null)) {
                NVASpeechKit.c(this.a).onAudioLevelUpdate(d);
            }
            if ((NVASpeechKit.d(this.a) == NVASpeechKit.State.RECORDING) || (NVASpeechKit.b(this.a).d)) {
                NVASpeechKit.f(this.a).postDelayed(NVASpeechKit.e(this.a), 50L);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */