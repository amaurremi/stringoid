package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

class BridgeMMInlineVideo$8
        implements Callable<MMJSResponse> {
    BridgeMMInlineVideo$8(BridgeMMInlineVideo paramBridgeMMInlineVideo, Map paramMap) {
    }

    public MMJSResponse call() {
        Object localObject = (MMWebView) this.b.c.get();
        if (localObject != null) {
            localObject = ((MMWebView) localObject).h();
            String str = (String) this.a.get("streamVideoURI");
            if ((localObject != null) && (str != null)) {
                ((MMLayout) localObject).setVideoSource(str);
                return MMJSResponse.a();
            }
        }
        return MMJSResponse.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMInlineVideo$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */