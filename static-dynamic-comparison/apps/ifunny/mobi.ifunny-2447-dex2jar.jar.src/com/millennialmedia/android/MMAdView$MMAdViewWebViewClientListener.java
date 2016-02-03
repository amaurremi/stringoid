package com.millennialmedia.android;

import java.lang.ref.WeakReference;

class MMAdView$MMAdViewWebViewClientListener
        extends MMAdImpl.BasicWebViewClientListener {
    MMAdView$MMAdViewWebViewClientListener(MMAdImpl paramMMAdImpl) {
        super(paramMMAdImpl);
    }

    public void onPageFinished(String paramString) {
        super.onPageFinished(paramString);
        paramString = (MMAdImpl) this.a.get();
        if ((paramString != null) && (paramString.h())) {
            paramString.i();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdView$MMAdViewWebViewClientListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */