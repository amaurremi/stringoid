package com.mopub.mobileads;

import com.mopub.common.GpsHelper.GpsHelperListener;

class MoPubConversionTracker$ConversionTrackerGpsHelperListener
        implements GpsHelper.GpsHelperListener {
    MoPubConversionTracker$ConversionTrackerGpsHelperListener(MoPubConversionTracker paramMoPubConversionTracker) {
    }

    public void onFetchAdInfoCompleted() {
        new Thread(new MoPubConversionTracker.TrackOpen(this.this$0, null)).start();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubConversionTracker$ConversionTrackerGpsHelperListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */