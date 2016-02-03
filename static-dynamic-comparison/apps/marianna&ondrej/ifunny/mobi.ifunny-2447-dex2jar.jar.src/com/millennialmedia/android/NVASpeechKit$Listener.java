package com.millennialmedia.android;

public abstract interface NVASpeechKit$Listener {
    public abstract void onAudioLevelUpdate(double paramDouble);

    public abstract void onAudioSampleUpdate(double paramDouble);

    public abstract void onCustomWordsAdded();

    public abstract void onCustomWordsDeleted();

    public abstract void onError();

    public abstract void onResults();

    public abstract void onStateChange(NVASpeechKit.State paramState);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$Listener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */