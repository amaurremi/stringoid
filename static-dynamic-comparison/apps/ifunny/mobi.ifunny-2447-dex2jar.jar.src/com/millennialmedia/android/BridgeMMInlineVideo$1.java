package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

class BridgeMMInlineVideo$1
        implements Callable<MMJSResponse> {
    BridgeMMInlineVideo$1(BridgeMMInlineVideo paramBridgeMMInlineVideo, Map paramMap) {
    }

    public MMJSResponse call() {
        MMWebView localMMWebView = (MMWebView) this.b.c.get();
        if (localMMWebView != null) {
            MMLayout localMMLayout = localMMWebView.h();
            localMMLayout.b(new InlineVideoView.InlineParams(this.a, localMMWebView.getContext()));
            return MMJSResponse.a("usingStreaming=" + localMMLayout.r());
        }
        return MMJSResponse.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMInlineVideo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */