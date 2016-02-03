package com.millennialmedia.android;

public abstract interface MMAd {
    public abstract String getApid();

    public abstract boolean getIgnoresDensityScaling();

    public abstract RequestListener getListener();

    public abstract MMRequest getMMRequest();

    public abstract void setApid(String paramString);

    public abstract void setIgnoresDensityScaling(boolean paramBoolean);

    public abstract void setListener(RequestListener paramRequestListener);

    public abstract void setMMRequest(MMRequest paramMMRequest);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */