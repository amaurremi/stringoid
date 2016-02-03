package com.millennialmedia.android;

public abstract interface RequestListener {
    public abstract void MMAdOverlayClosed(MMAd paramMMAd);

    public abstract void MMAdOverlayLaunched(MMAd paramMMAd);

    public abstract void MMAdRequestIsCaching(MMAd paramMMAd);

    public abstract void onSingleTap(MMAd paramMMAd);

    public abstract void requestCompleted(MMAd paramMMAd);

    public abstract void requestFailed(MMAd paramMMAd, MMException paramMMException);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/RequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */