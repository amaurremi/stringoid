package com.uservoice.uservoicesdk.rest;

public abstract class Callback<T> {
    public abstract void onError(RestResult paramRestResult);

    public abstract void onModel(T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/rest/Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */