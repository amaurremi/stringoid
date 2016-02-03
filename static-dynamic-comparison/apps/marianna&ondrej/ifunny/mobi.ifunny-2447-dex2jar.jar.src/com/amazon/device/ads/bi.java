package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebView;

class bi {
    protected bg a(ah paramah, ab paramab, WebView paramWebView, Context paramContext) {
        return new dd(paramah, paramab, paramWebView, paramContext);
    }

    public bg a(ai paramai, ah paramah, ab paramab, WebView paramWebView, Context paramContext) {
        switch (bj.a[paramai.ordinal()]) {
            default:
                return null;
            case 1:
                return a(paramah, paramab, paramWebView, paramContext);
        }
        return b(paramah, paramab, paramWebView, paramContext);
    }

    protected Class<?> a(ai paramai) {
        switch (bj.a[paramai.ordinal()]) {
            default:
                return null;
            case 1:
                return dd.class;
        }
        return fu.class;
    }

    public boolean a(ai paramai, bg parambg) {
        return (parambg == null) || (!parambg.k()) || (parambg.getClass() != a(paramai));
    }

    protected bg b(ah paramah, ab paramab, WebView paramWebView, Context paramContext) {
        return new fu(paramah, paramab, paramWebView, paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */