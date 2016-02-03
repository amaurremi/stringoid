package com.bumptech.glide.resize.cache;

import java.io.InputStream;
import java.io.OutputStream;

public abstract interface DiskCache {
    public abstract void delete(String paramString);

    public abstract InputStream get(String paramString);

    public abstract void put(String paramString, Writer paramWriter);

    public static abstract interface Writer {
        public abstract void write(OutputStream paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/cache/DiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */