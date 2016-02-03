package com.everimaging.fotorsdk.utils;

import android.support.v4.util.LruCache;

public class FotorLruCache<K, V>
        extends LruCache<K, V> {
    public FotorLruCache(int paramInt) {
        super(paramInt);
    }

    protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {
        super.entryRemoved(paramBoolean, paramK, paramV1, paramV2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/FotorLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */