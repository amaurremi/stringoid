package com.millennialmedia.android;

class BridgeMMSpeechkit$SpeechKitHolder$1
        implements Runnable {
    BridgeMMSpeechkit$SpeechKitHolder$1(BridgeMMSpeechkit.SpeechKitHolder paramSpeechKitHolder) {
    }

    public void run() {
        synchronized (this.a) {
            if (BridgeMMSpeechkit.SpeechKitHolder.a(this.a) != null) {
                BridgeMMSpeechkit.SpeechKitHolder.a(this.a).cancelRecording();
                BridgeMMSpeechkit.SpeechKitHolder.a(this.a).release();
                BridgeMMSpeechkit.SpeechKitHolder.a(this.a, null);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMSpeechkit$SpeechKitHolder$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */