package com.millennialmedia.android;

import android.util.Log;

public class RequestListener$RequestListenerImpl
        implements RequestListener {
    public void MMAdOverlayClosed(MMAd paramMMAd) {
        Log.i("MMSDK", "Millennial Media Ad View overlay closed");
    }

    public void MMAdOverlayLaunched(MMAd paramMMAd) {
        Log.i("MMSDK", "Millennial Media Ad View overlay launched");
    }

    public void MMAdRequestIsCaching(MMAd paramMMAd) {
        Log.i("MMSDK", "Millennial Media Ad View caching request");
    }

    public void onSingleTap(MMAd paramMMAd) {
        Log.i("MMSDK", "Ad tapped");
    }

    public void requestCompleted(MMAd paramMMAd) {
        Log.i("MMSDK", "Ad request succeeded");
    }

    public void requestFailed(MMAd paramMMAd, MMException paramMMException) {
        Log.i("MMSDK", String.format("Ad request failed with error: %d %s.", new Object[]{Integer.valueOf(paramMMException.getCode()), paramMMException.getMessage()}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/RequestListener$RequestListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */