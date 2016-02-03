package com.bumptech.glide.loader.model;

import com.bumptech.glide.loader.stream.StreamLoader;

public abstract interface ModelLoader<T> {
    public abstract String getId(T paramT);

    public abstract StreamLoader getStreamLoader(T paramT, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/ModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */