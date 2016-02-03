package com.millennialmedia.android;

public enum NVASpeechKit$State {
    private String a;

    static {
        RECORDING = new State("RECORDING", 2, "recording");
        READY = new State("READY", 3, "ready");
    }

    private NVASpeechKit$State(String paramString) {
        this.a = paramString;
    }

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */