package com.inneractive.api.ads.sdk;

import android.os.SystemClock;
import android.view.MotionEvent;

final class IAbaseWebView$2$1
        implements Runnable {
    IAbaseWebView$2$1(IAbaseWebView.2param2) {
    }

    public final void run() {
        InneractiveAdView.Log.v("Inneractive_verbose", "performVastAutoclick --> 2");
        MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, 1, c.p(this.a.a.mContext) / 2, c.o(this.a.a.mContext) / 2, 0);
        InneractiveAdView.Log.v("Inneractive_verbose", "second post delayed --> before dipatchTouch");
        this.a.a.dispatchTouchEvent(localMotionEvent);
        InneractiveAdView.Log.v("Inneractive_verbose", "second post delayed --> after dipatchTouch");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAbaseWebView$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */