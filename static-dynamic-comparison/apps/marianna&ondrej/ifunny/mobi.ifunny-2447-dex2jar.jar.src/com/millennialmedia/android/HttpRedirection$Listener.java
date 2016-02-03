package com.millennialmedia.android;

import android.net.Uri;

abstract interface HttpRedirection$Listener {
    public abstract boolean canOpenOverlay();

    public abstract OverlaySettings getOverlaySettings();

    public abstract boolean isActivityStartable(Uri paramUri);

    public abstract boolean isExpandingToUrl();

    public abstract boolean isHandlingMMVideo(Uri paramUri);

    public abstract void startingActivity(Uri paramUri);

    public abstract void startingVideo();

    public abstract void updateLastVideoViewedTime();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpRedirection$Listener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */