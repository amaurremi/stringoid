package com.millennialmedia.android;

import java.util.Stack;

class ComponentRegistry {
    static Stack<ExampleComponent> a = new Stack();
    static Stack<BridgeMMBanner> b = new Stack();
    static Stack<BridgeMMCachedVideo> c = new Stack();
    static Stack<BridgeMMCalendar> d = new Stack();
    static Stack<BridgeMMDevice> e = new Stack();
    static Stack<BridgeMMInlineVideo> f = new Stack();
    static Stack<BridgeMMInterstitial> g = new Stack();
    static Stack<BridgeMMMedia> h = new Stack();
    static Stack<BridgeMMNotification> i = new Stack();
    static Stack<BridgeMMSpeechkit> j = new Stack();
    static Stack<MMLog.LoggingComponent> k = new Stack();

    static BridgeMMBanner a() {
        return (BridgeMMBanner) a(b);
    }

    private static <T> T a(Stack<T> paramStack) {
        if (paramStack.isEmpty()) {
            return null;
        }
        return (T) paramStack.lastElement();
    }

    static void a(BridgeMMBanner paramBridgeMMBanner) {
        b.push(paramBridgeMMBanner);
    }

    static void a(BridgeMMCachedVideo paramBridgeMMCachedVideo) {
        c.push(paramBridgeMMCachedVideo);
    }

    static void a(BridgeMMCalendar paramBridgeMMCalendar) {
        d.push(paramBridgeMMCalendar);
    }

    static void a(BridgeMMDevice paramBridgeMMDevice) {
        e.push(paramBridgeMMDevice);
    }

    static void a(BridgeMMInlineVideo paramBridgeMMInlineVideo) {
        f.push(paramBridgeMMInlineVideo);
    }

    static void a(BridgeMMInterstitial paramBridgeMMInterstitial) {
        g.push(paramBridgeMMInterstitial);
    }

    static void a(BridgeMMMedia paramBridgeMMMedia) {
        h.push(paramBridgeMMMedia);
    }

    static void a(BridgeMMNotification paramBridgeMMNotification) {
        i.push(paramBridgeMMNotification);
    }

    static void a(BridgeMMSpeechkit paramBridgeMMSpeechkit) {
        j.push(paramBridgeMMSpeechkit);
    }

    static void a(MMLog.LoggingComponent paramLoggingComponent) {
        k.push(paramLoggingComponent);
    }

    static BridgeMMCachedVideo b() {
        return (BridgeMMCachedVideo) a(c);
    }

    static BridgeMMCalendar c() {
        return (BridgeMMCalendar) a(d);
    }

    static BridgeMMDevice d() {
        return (BridgeMMDevice) a(e);
    }

    static BridgeMMInlineVideo e() {
        return (BridgeMMInlineVideo) a(f);
    }

    static BridgeMMInterstitial f() {
        return (BridgeMMInterstitial) a(g);
    }

    static BridgeMMMedia g() {
        return (BridgeMMMedia) a(h);
    }

    static BridgeMMNotification h() {
        return (BridgeMMNotification) a(i);
    }

    static BridgeMMSpeechkit i() {
        return (BridgeMMSpeechkit) a(j);
    }

    static MMLog.LoggingComponent j() {
        return (MMLog.LoggingComponent) a(k);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/ComponentRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */