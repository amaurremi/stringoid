package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

class BridgeMMNotification$1
        implements Callable<MMJSResponse> {
    BridgeMMNotification$1(BridgeMMNotification paramBridgeMMNotification, Map paramMap) {
    }

    public MMJSResponse call() {
        Object localObject1 = (MMWebView) this.b.c.get();
        if (localObject1 != null) {
            Object localObject2 = ((MMWebView) localObject1).i();
            localObject1 = this.a;
            if (localObject2 != null) {
                if (!((Activity) localObject2).isFinishing()) {
                    localObject2 = new AlertDialog.Builder((Context) localObject2).create();
                    if (((Map) localObject1).containsKey("title")) {
                        ((AlertDialog) localObject2).setTitle((CharSequence) ((Map) localObject1).get("title"));
                    }
                    if (((Map) localObject1).containsKey("message")) {
                        ((AlertDialog) localObject2).setMessage((CharSequence) ((Map) localObject1).get("message"));
                    }
                    if (((Map) localObject1).containsKey("cancelButton")) {
                        ((AlertDialog) localObject2).setButton(-2, (CharSequence) ((Map) localObject1).get("cancelButton"), this.b);
                    }
                    if (((Map) localObject1).containsKey("buttons")) {
                        localObject1 = ((String) ((Map) localObject1).get("buttons")).split(",");
                        if (localObject1.length > 0) {
                            ((AlertDialog) localObject2).setButton(-3, localObject1[0], this.b);
                        }
                        if (localObject1.length > 1) {
                            ((AlertDialog) localObject2).setButton(-1, localObject1[1], this.b);
                        }
                    }
                    ((AlertDialog) localObject2).show();
                }
                localObject1 = new MMJSResponse();
                ((MMJSResponse) localObject1).c = 1;
                ((MMJSResponse) localObject1).d = Integer.valueOf(BridgeMMNotification.a(this.b));
                return (MMJSResponse) localObject1;
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMNotification$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */