package com.millennialmedia.android;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer.Listener;

class NVASpeechKit$6
        implements Vocalizer.Listener {
    NVASpeechKit$6(NVASpeechKit paramNVASpeechKit) {
    }

    public void onSpeakingBegin(Vocalizer paramVocalizer, String paramString, Object paramObject) {
        MMLog.b("NVASpeechKit", "Vocalization begins. text=" + paramString);
        NVASpeechKit.a(this.a, NVASpeechKit.State.VOCALIZING);
    }

    public void onSpeakingDone(Vocalizer paramVocalizer, String paramString, SpeechError paramSpeechError, Object paramObject) {
        MMLog.b("NVASpeechKit", "Vocalization has ended.");
        if (paramSpeechError != null) {
            MMLog.e("NVASpeechKit", "Vocalizer error: " + paramSpeechError.getErrorDetail());
            NVASpeechKit.a(this.a, paramSpeechError);
            return;
        }
        NVASpeechKit.a(this.a, NVASpeechKit.State.READY);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */