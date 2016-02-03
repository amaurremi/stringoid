package com.millennialmedia.android;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

abstract class MMJSObject {
    private static final String a = MMJSObject.class.getName();
    protected WeakReference<Context> b;
    protected WeakReference<MMWebView> c;

    abstract MMJSResponse a(String paramString, Map<String, String> paramMap);

    MMJSResponse a(Callable<MMJSResponse> paramCallable) {
        paramCallable = new FutureTask(paramCallable);
        MMSDK.a(paramCallable);
        try {
            paramCallable = (MMJSResponse) paramCallable.get();
            return paramCallable;
        } catch (InterruptedException paramCallable) {
            MMLog.a(a, "Future interrupted", paramCallable);
            return null;
        } catch (ExecutionException paramCallable) {
            for (; ; ) {
                MMLog.a(a, "Future execution problem: ", paramCallable);
            }
        }
    }

    void a(MMWebView paramMMWebView) {
        this.c = new WeakReference(paramMMWebView);
    }

    long b(String paramString) {
        if (paramString != null) {
            return Float.parseFloat(paramString);
        }
        return -4L;
    }

    void c(Context paramContext) {
        this.b = new WeakReference(paramContext);
    }

    AdViewOverlayActivity d() {
        Object localObject = (MMWebView) this.c.get();
        if (localObject != null) {
            localObject = ((MMWebView) localObject).i();
            if ((localObject instanceof MMActivity)) {
                localObject = ((MMActivity) localObject).h();
                if ((localObject instanceof AdViewOverlayActivity)) {
                    return (AdViewOverlayActivity) localObject;
                }
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMJSObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */