package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

class BridgeMMInlineVideo$6
        implements Callable<MMJSResponse> {
    BridgeMMInlineVideo$6(BridgeMMInlineVideo paramBridgeMMInlineVideo) {
    }

    public MMJSResponse call() {
        Object localObject = (MMWebView) this.a.c.get();
        if (localObject != null) {
            localObject = ((MMWebView) localObject).h();
            if (localObject != null) {
                ((MMLayout) localObject).p();
                return MMJSResponse.a();
            }
        }
        return MMJSResponse.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMInlineVideo$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */