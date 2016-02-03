package com.bumptech.glide.loader.transformation;

import com.bumptech.glide.resize.load.Transformation;

public abstract interface TransformationLoader<T> {
    public abstract String getId();

    public abstract Transformation getTransformation(T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/transformation/TransformationLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */