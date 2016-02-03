package com.inmobi.re.container;

import com.inmobi.commons.internal.Log;

class IMWebView$k
        implements Runnable {
    IMWebView$k(IMWebView paramIMWebView) {
    }

    public void run() {
        try {
            this.a.injectJavaScript("window.mraid.broadcastEvent('vibrateComplete')");
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception giviing vibration complete callback", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */