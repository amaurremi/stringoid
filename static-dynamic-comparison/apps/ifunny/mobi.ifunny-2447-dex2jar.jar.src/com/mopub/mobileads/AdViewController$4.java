package com.mopub.mobileads;

import android.view.View;

class AdViewController$4
        implements Runnable {
    AdViewController$4(AdViewController paramAdViewController, View paramView) {
    }

    public void run() {
        MoPubView localMoPubView = this.this$0.getMoPubView();
        if (localMoPubView == null) {
            return;
        }
        localMoPubView.removeAllViews();
        localMoPubView.addView(this.val$view, AdViewController.access$100(this.this$0, this.val$view));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdViewController$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */