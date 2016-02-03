package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;

class ig {
    private static ig a = new ig();
    private static boolean b = false;
    private boolean c = false;

    public static final ig a() {
        return a;
    }

    protected static boolean a(SQLiteException paramSQLiteException) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cf.a(paramSQLiteException);
        }
        return a(paramSQLiteException);
    }

    protected static boolean a(Exception paramException) {
        if ((paramException == null) || (paramException.getMessage() == null)) {
            return false;
        }
        return paramException.getMessage().contains("database is locked");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static final boolean a(boolean paramBoolean, WebView paramWebView, String paramString) {
        try {
            paramWebView.getSettings().setJavaScriptEnabled(paramBoolean);
            return true;
        } catch (NullPointerException paramWebView) {
            dv.e(paramString, "Could not set JavaScriptEnabled because a NullPointerException was encountered.");
        }
        return false;
    }

    private void b() {
        if (this.c) {
            String str2 = dn.i().c().b();
            String str1 = str2;
            if (str2 == null) {
                str1 = "";
            }
            a("http://amazon-adsystem.com", "ad-id=" + str1 + "; Domain=.amazon-adsystem.com");
        }
    }

    public static boolean b(Context paramContext) {
        boolean bool = false;
        if ((Build.VERSION.SDK_INT <= 8) && (!b)) {
            if (WebViewDatabase.getInstance(paramContext) != null) {
            }
        }
        for (; ; ) {
            return bool;
            try {
                paramContext = paramContext.openOrCreateDatabase("webviewCache.db", 0, null);
                if (paramContext != null) {
                    paramContext.close();
                }
                b = true;
                return true;
            } catch (SQLiteException paramContext) {
                bool = a(paramContext);
            } finally {
                if (0 != 0) {
                    throw new NullPointerException();
                }
            }
        }
    }

    public WebView a(Context paramContext) {
        try {
            WebView localWebView = new WebView(paramContext);
            if (!this.c) {
                CookieSyncManager.createInstance(paramContext);
                this.c = true;
            }
            b();
            return localWebView;
        } finally {
        }
    }

    protected void a(String paramString1, String paramString2) {
        CookieManager.getInstance().setCookie(paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */