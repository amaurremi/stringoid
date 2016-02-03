package com.bumptech.glide.loader.model;

import android.content.Context;

public abstract interface ModelLoaderFactory<T> {
    public abstract ModelLoader<T> build(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory);

    public abstract Class<? extends ModelLoader<T>> loaderClass();

    public abstract void teardown();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/ModelLoaderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */