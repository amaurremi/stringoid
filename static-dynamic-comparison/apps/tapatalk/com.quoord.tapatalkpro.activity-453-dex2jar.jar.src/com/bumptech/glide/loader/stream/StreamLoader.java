package com.bumptech.glide.loader.stream;

import java.io.InputStream;

public abstract interface StreamLoader {
    public abstract void cancel();

    public abstract void loadStream(StreamReadyCallback paramStreamReadyCallback);

    public static abstract interface StreamReadyCallback {
        public abstract void onException(Exception paramException);

        public abstract void onStreamReady(InputStream paramInputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/stream/StreamLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */