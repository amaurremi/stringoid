package com.mopub.mobileads;

import com.mopub.common.GpsHelper.GpsHelperListener;

class AdViewController$AdViewControllerGpsHelperListener
        implements GpsHelper.GpsHelperListener {
    AdViewController$AdViewControllerGpsHelperListener(AdViewController paramAdViewController) {
    }

    public void onFetchAdInfoCompleted() {
        String str = this.this$0.generateAdUrl();
        this.this$0.loadNonJavascript(str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdViewController$AdViewControllerGpsHelperListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */