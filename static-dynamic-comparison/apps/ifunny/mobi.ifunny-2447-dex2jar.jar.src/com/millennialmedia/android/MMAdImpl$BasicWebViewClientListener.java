package com.millennialmedia.android;

import java.lang.ref.WeakReference;

class MMAdImpl$BasicWebViewClientListener
        extends MMWebViewClient.MMWebViewClientListener {
    WeakReference<MMAdImpl> a;

    MMAdImpl$BasicWebViewClientListener(MMAdImpl paramMMAdImpl) {
        this.a = new WeakReference(paramMMAdImpl);
    }

    void a(String paramString) {
        paramString = (MMAdImpl) this.a.get();
        if (paramString != null) {
            paramString.setClickable(false);
        }
    }

    public void onPageFinished(String arg1) {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.a.get();
        if (localMMAdImpl != null) {
            localMMAdImpl.setClickable(true);
            if ((localMMAdImpl.k != null) && (localMMAdImpl.k.b != null)) {
                synchronized (localMMAdImpl.k.b) {
                    if (localMMAdImpl.k.b.hasWindowFocus()) {
                        localMMAdImpl.k.b.q();
                        return;
                    }
                    localMMAdImpl.k.b.p();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdImpl$BasicWebViewClientListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */