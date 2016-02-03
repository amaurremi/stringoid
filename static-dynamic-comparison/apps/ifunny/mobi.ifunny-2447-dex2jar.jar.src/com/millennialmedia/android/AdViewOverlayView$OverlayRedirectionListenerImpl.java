package com.millennialmedia.android;

import java.lang.ref.WeakReference;

class AdViewOverlayView$OverlayRedirectionListenerImpl
        extends MMAdImpl.MMAdImplRedirectionListenerImpl {
    public AdViewOverlayView$OverlayRedirectionListenerImpl(MMAdImpl paramMMAdImpl) {
        super(paramMMAdImpl);
    }

    public boolean isExpandingToUrl() {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.f.get();
        if ((localMMAdImpl != null) && ((localMMAdImpl instanceof AdViewOverlayView.AdViewOverlayViewMMAdImpl))) {
            return localMMAdImpl.b();
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$OverlayRedirectionListenerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */