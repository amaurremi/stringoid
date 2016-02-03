package com.inneractive.api.ads.sdk;

import android.os.SystemClock;
import android.view.MotionEvent;

final class IAbaseWebView$2
        implements Runnable {
    IAbaseWebView$2(IAbaseWebView paramIAbaseWebView) {
    }

    public final void run() {
        MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, 0, c.p(this.a.mContext) / 2, c.o(this.a.mContext) / 2, 0);
        InneractiveAdView.Log.v("Inneractive_verbose", " --> before dipatchTouch");
        this.a.dispatchTouchEvent(localMotionEvent);
        InneractiveAdView.Log.v("Inneractive_verbose", " --> after dipatchTouch");
        this.a.post(new IAbaseWebView .2 .1 (this));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAbaseWebView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */