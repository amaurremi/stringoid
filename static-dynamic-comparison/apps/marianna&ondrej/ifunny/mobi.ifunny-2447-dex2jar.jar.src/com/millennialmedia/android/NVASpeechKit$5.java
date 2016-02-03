package com.millennialmedia.android;

import org.json.JSONArray;

class NVASpeechKit$5
        implements NVASpeechKit.Listener {
    NVASpeechKit$5(NVASpeechKit paramNVASpeechKit) {
    }

    public void onAudioLevelUpdate(double paramDouble) {
        this.a.a(paramDouble);
    }

    public void onAudioSampleUpdate(double paramDouble) {
        this.a.b(paramDouble);
    }

    public void onCustomWordsAdded() {
    }

    public void onCustomWordsDeleted() {
    }

    public void onError() {
    }

    public void onResults() {
        JSONArray localJSONArray = NVASpeechKit.a(this.a, this.a.getResults());
        this.a.a(localJSONArray.toString());
    }

    public void onStateChange(NVASpeechKit.State paramState) {
        switch (NVASpeechKit .8.a[paramState.ordinal()])
        {
            default:
                return;
            case 1:
                this.a.e();
                return;
            case 2:
                this.a.c();
                return;
            case 3:
                this.a.a();
                return;
            case 4:
                this.a.b();
                return;
        }
        this.a.d();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */