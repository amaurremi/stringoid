package com.millennialmedia.android;

class BridgeMMSpeechkit$SpeechKitHolder {
    private NVASpeechKit a;

    public NVASpeechKit getSpeechKit() {
        return this.a;
    }

    public boolean release() {
        if (this.a == null) {
            return false;
        }
        Utils.ThreadUtils.a(new BridgeMMSpeechkit.SpeechKitHolder .1 (this));
        return true;
    }

    public void setSpeechKit(NVASpeechKit paramNVASpeechKit) {
        this.a = paramNVASpeechKit;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMSpeechkit$SpeechKitHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */