package com.mopub.nativeads;

import android.os.SystemClock;

class TimestampWrapper<T> {
    long mCreatedTimestamp;
    final T mInstance;

    TimestampWrapper(T paramT) {
        this.mInstance = paramT;
        this.mCreatedTimestamp = SystemClock.uptimeMillis();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/TimestampWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */