package com.millennialmedia.android;

import android.net.Uri;
import android.text.TextUtils;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class MMCommand
        implements Runnable {
    private WeakReference<MMWebView> a;
    private String b;
    private String c;
    private String d;
    private Map<String, String> e;

    static {
        ComponentRegistry.a(new BridgeMMBanner());
        ComponentRegistry.a(new BridgeMMCachedVideo());
        ComponentRegistry.a(new BridgeMMCalendar());
        ComponentRegistry.a(new BridgeMMDevice());
        ComponentRegistry.a(new BridgeMMInlineVideo());
        ComponentRegistry.a(new BridgeMMInterstitial());
        ComponentRegistry.a(new BridgeMMMedia());
        ComponentRegistry.a(new BridgeMMNotification());
        ComponentRegistry.a(new BridgeMMSpeechkit());
    }

    MMCommand(MMWebView paramMMWebView, String paramString) {
        this.a = new WeakReference(paramMMWebView);
        try {
            paramMMWebView = Uri.parse(paramString).getHost().split("\\.");
            if (paramMMWebView.length != 2) {
                return;
            }
            this.b = paramMMWebView[0];
            this.c = paramMMWebView[1];
            this.e = new HashMap();
            paramMMWebView = paramString.substring(paramString.indexOf('?') + 1).split("&");
            int j = paramMMWebView.length;
            int i = 0;
            while (i < j) {
                String[] arrayOfString = paramMMWebView[i].split("=");
                if (arrayOfString.length >= 2) {
                    this.e.put(Uri.decode(arrayOfString[0]), Uri.decode(arrayOfString[1]));
                    if (arrayOfString[0].equalsIgnoreCase("callback")) {
                        this.d = Uri.decode(arrayOfString[1]);
                    }
                }
                i += 1;
            }
            return;
        } catch (Exception paramMMWebView) {
            MMLog.a("MMCommand", String.format("Exception while executing javascript call %s ", new Object[]{paramString}), paramMMWebView);
            paramMMWebView.printStackTrace();
        }
    }

    private MMJSObject a(String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramString != null) {
            if (!"MMBanner".equals(paramString)) {
                break label23;
            }
            localObject1 = ComponentRegistry.a();
        }
        label23:
        do {
            return (MMJSObject) localObject1;
            if ("MMCachedVideo".equals(paramString)) {
                return ComponentRegistry.b();
            }
            if ("MMCalendar".equals(paramString)) {
                return ComponentRegistry.c();
            }
            if ("MMDevice".equals(paramString)) {
                return ComponentRegistry.d();
            }
            if ("MMInlineVideo".equals(paramString)) {
                return ComponentRegistry.e();
            }
            if ("MMInterstitial".equals(paramString)) {
                return ComponentRegistry.f();
            }
            if ("MMMedia".equals(paramString)) {
                return ComponentRegistry.g();
            }
            if ("MMNotification".equals(paramString)) {
                return ComponentRegistry.h();
            }
            localObject1 = localObject2;
        } while (!"MMSpeechkit".equals(paramString));
        return ComponentRegistry.i();
    }

    private String b() {
        return this.b.replaceFirst("Bridge", "");
    }

    boolean a() {
        if (this.c != null) {
            return "resize".equals(this.c);
        }
        return false;
    }

    public void run() {
        Object localObject1 = null;
        label369:
        for (; ; ) {
            try {
                Object localObject4;
                if (this.b != null) {
                    Object localObject2 = this.c;
                    if (localObject2 != null) {
                        try {
                            localObject2 = (MMWebView) this.a.get();
                            if (localObject2 == null) {
                                break label369;
                            }
                            localObject4 = a(this.b);
                            if (localObject4 == null) {
                                continue;
                            }
                            ((MMJSObject) localObject4).c(((MMWebView) localObject2).getContext());
                            ((MMJSObject) localObject4).a((MMWebView) localObject2);
                            ((MMWebView) localObject2).a(this.e);
                            localObject2 = ((MMJSObject) localObject4).a(this.c, this.e);
                            localObject1 = localObject2;
                        } catch (Exception localException) {
                            MMLog.a("MMCommand", "Exception while executing javascript call " + this.c, localException);
                            localMMJSResponse = MMJSResponse.b("Unexpected exception, " + localException.getClass().getName() + " received.");
                            localObject1 = localMMJSResponse;
                            continue;
                        }
                        if (!TextUtils.isEmpty(this.d)) {
                            localObject4 = (MMWebView) this.a.get();
                            if (localObject4 != null) {
                                localObject2 = localObject1;
                                if (localObject1 == null) {
                                    localObject2 = MMJSResponse.b(this.c);
                                }
                                if (((MMJSResponse) localObject2).b == null) {
                                    ((MMJSResponse) localObject2).b = this.c;
                                }
                                if (((MMJSResponse) localObject2).a == null) {
                                    ((MMJSResponse) localObject2).a = b();
                                }
                                MMSDK.a(new MMCommand .1 (this, (MMWebView) localObject4, (MMJSResponse) localObject2));
                            }
                        }
                        return;
                        localObject2 = MMJSResponse.b("Service: " + this.b + " does not exist.");
                        localObject1 = localObject2;
                        continue;
                    }
                }
                MMJSResponse localMMJSResponse = MMJSResponse.b("The service or service method was not defined.");
                localObject1 = localMMJSResponse;
                continue;
                localObject1 = null;
            } finally {
                if (!TextUtils.isEmpty(this.d)) {
                    localObject4 = (MMWebView) this.a.get();
                    if (localObject4 != null) {
                        if (0 == 0) {
                            localObject1 = MMJSResponse.b(this.c);
                        }
                        if (((MMJSResponse) localObject1).b == null) {
                            ((MMJSResponse) localObject1).b = this.c;
                        }
                        if (((MMJSResponse) localObject1).a == null) {
                            ((MMJSResponse) localObject1).a = b();
                        }
                        MMSDK.a(new MMCommand .1 (this, (MMWebView) localObject4, (MMJSResponse) localObject1));
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */