package com.mopub.nativeads;

import android.view.ViewTreeObserver.OnPreDrawListener;

class VisibilityTracker$1
        implements ViewTreeObserver.OnPreDrawListener {
    VisibilityTracker$1(VisibilityTracker paramVisibilityTracker) {
    }

    public boolean onPreDraw() {
        this.this$0.scheduleVisibilityCheck();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/VisibilityTracker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */