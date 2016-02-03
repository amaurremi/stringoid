package com.millennialmedia.android;

import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer.Listener;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.SpeechKit;

class NVASpeechKit$7
        implements Recognizer.Listener {
    NVASpeechKit$7(NVASpeechKit paramNVASpeechKit) {
    }

    public void onError(Recognizer paramRecognizer, SpeechError paramSpeechError) {
        MMLog.b("NVASpeechKit", "Speech Kit Error code:" + paramSpeechError.getErrorCode() + " detail:" + paramSpeechError.getErrorDetail() + " suggestions:" + paramSpeechError.getSuggestion());
        NVASpeechKit.k(this.a);
        NVASpeechKit.a(this.a, paramSpeechError);
        NVASpeechKit.b(this.a, null);
        if (NVASpeechKit.l(this.a) != null) {
            MMLog.b("NVASpeechKit", "Recognizer.Listener.onError: session id [" + NVASpeechKit.l(this.a).getSessionId() + "]");
        }
    }

    public void onRecordingBegin(Recognizer paramRecognizer) {
        MMLog.b("NVASpeechKit", "recording begins");
        this.a._results = null;
        if (!NVASpeechKit.b(this.a).isTrackingAudioSample()) {
            NVASpeechKit.a(this.a, NVASpeechKit.State.RECORDING);
        }
        NVASpeechKit.a(this.a, paramRecognizer);
        if (NVASpeechKit.b(this.a).isTrackingAudioSample()) {
            NVASpeechKit.f(this.a).removeCallbacks(NVASpeechKit.j(this.a));
            NVASpeechKit.f(this.a).postDelayed(NVASpeechKit.j(this.a), 2000L);
        }
    }

    public void onRecordingDone(Recognizer paramRecognizer) {
        MMLog.b("NVASpeechKit", "recording has ended");
        NVASpeechKit.k(this.a);
        if (!NVASpeechKit.b(this.a).isTrackingAudioSample()) {
            NVASpeechKit.a(this.a, NVASpeechKit.State.PROCESSING);
        }
        if (NVASpeechKit.l(this.a) != null) {
            NVASpeechKit.a(this.a, NVASpeechKit.l(this.a).getSessionId());
        }
    }

    public void onResults(Recognizer paramRecognizer, Recognition paramRecognition) {
        MMLog.b("NVASpeechKit", "recording results returned.");
        NVASpeechKit.k(this.a);
        if (!NVASpeechKit.b(this.a).d) {
            NVASpeechKit.a(this.a, paramRecognition.getDetailedResults());
            if (NVASpeechKit.m(this.a) != null) {
                MMLog.b("NVASpeechKit", "Recognizer.Listener.onResults: session id [" + NVASpeechKit.m(this.a) + "]");
            }
            this.a.logEvent();
            return;
        }
        this.a._results = new NVASpeechKit.Result[0];
        NVASpeechKit.g(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */