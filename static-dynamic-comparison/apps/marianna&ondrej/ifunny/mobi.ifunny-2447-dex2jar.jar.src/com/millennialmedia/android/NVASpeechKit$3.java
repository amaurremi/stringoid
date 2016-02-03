package com.millennialmedia.android;

import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericCommand.Listener;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.SpeechError;

class NVASpeechKit$3
        implements GenericCommand.Listener {
    NVASpeechKit$3(NVASpeechKit paramNVASpeechKit) {
    }

    public void onComplete(GenericCommand paramGenericCommand, GenericResult paramGenericResult, SpeechError paramSpeechError) {
        if (paramSpeechError != null) {
            MMLog.e("NVASpeechKit", "GenericCommand listener. Error: " + paramSpeechError.getErrorDetail());
        }
        for (; ; ) {
            NVASpeechKit.g(this.a);
            return;
            MMLog.b("NVASpeechKit", "GenericCommand listener. Success: " + paramGenericResult.getQueryResult());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */