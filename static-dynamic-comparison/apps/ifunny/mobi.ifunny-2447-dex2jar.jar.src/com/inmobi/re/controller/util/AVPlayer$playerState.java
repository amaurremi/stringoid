package com.inmobi.re.controller.util;

public enum AVPlayer$playerState {
    static {
        PAUSED = new playerState("PAUSED", 2);
        HIDDEN = new playerState("HIDDEN", 3);
        SHOWING = new playerState("SHOWING", 4);
    }

    private AVPlayer$playerState() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/util/AVPlayer$playerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */