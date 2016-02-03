package com.millennialmedia.android;

import android.content.Context;
import android.net.Uri;

import java.lang.ref.WeakReference;

class HttpRedirection$RedirectionListenerImpl
        implements HttpRedirection.Listener {
    String a;
    WeakReference<Context> b;
    Uri c;
    String d;
    long e;

    public boolean canOpenOverlay() {
        return false;
    }

    public OverlaySettings getOverlaySettings() {
        return null;
    }

    public boolean isActivityStartable(Uri paramUri) {
        return true;
    }

    public boolean isExpandingToUrl() {
        return false;
    }

    public boolean isHandlingMMVideo(Uri paramUri) {
        return false;
    }

    public void startingActivity(Uri paramUri) {
        MMLog.b("HttpRedirection", String.format("Starting activity for %s", new Object[]{paramUri}));
    }

    public void startingVideo() {
    }

    public void updateLastVideoViewedTime() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpRedirection$RedirectionListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */