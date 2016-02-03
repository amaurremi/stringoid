package com.millennialmedia.android;

import java.lang.ref.WeakReference;

class AdViewOverlayView$OverlayWebViewClientListener
        extends MMAdImpl.BasicWebViewClientListener {
    AdViewOverlayView$OverlayWebViewClientListener(MMAdImpl paramMMAdImpl) {
        super(paramMMAdImpl);
    }

    public void onPageFinished(String paramString) {
        super.onPageFinished(paramString);
        paramString = (MMAdImpl) this.a.get();
        if (paramString != null) {
            paramString.a();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$OverlayWebViewClientListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */