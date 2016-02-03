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

class WebViewFactory {
    private static WebViewFactory instance = new WebViewFactory();
    private static boolean isWebViewCheckedAndOk = false;
    private boolean cookieSyncManagerCreated = false;

    protected static boolean doesExceptionContainLockedDatabaseMessage(Exception paramException) {
        if ((paramException == null) || (paramException.getMessage() == null)) {
            return false;
        }
        return paramException.getMessage().contains("database is locked");
    }

    public static final WebViewFactory getInstance() {
        return instance;
    }

    protected static boolean isDatabaseLocked(SQLiteException paramSQLiteException) {
        if (Build.VERSION.SDK_INT >= 11) {
            return AndroidTargetUtils.isInstanceOfSQLiteDatabaseLockedException(paramSQLiteException);
        }
        return doesExceptionContainLockedDatabaseMessage(paramSQLiteException);
    }

    public static boolean isWebViewOk(Context paramContext) {
        boolean bool = false;
        if ((Build.VERSION.SDK_INT <= 8) && (!isWebViewCheckedAndOk)) {
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
                isWebViewCheckedAndOk = true;
                return true;
            } catch (SQLiteException paramContext) {
                bool = isDatabaseLocked(paramContext);
            } finally {
                if (0 != 0) {
                    throw new NullPointerException();
                }
            }
        }
    }

    protected static void setInstance(WebViewFactory paramWebViewFactory) {
        instance = paramWebViewFactory;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static final boolean setJavaScriptEnabledForWebView(boolean paramBoolean, WebView paramWebView, String paramString) {
        try {
            paramWebView.getSettings().setJavaScriptEnabled(paramBoolean);
            return true;
        } catch (NullPointerException paramWebView) {
            Log.w(paramString, "Could not set JavaScriptEnabled because a NullPointerException was encountered.");
        }
        return false;
    }

    private void updateAdIdCookie() {
        if (this.cookieSyncManagerCreated) {
            String str2 = InternalAdRegistration.getInstance().getRegistrationInfo().getAdId();
            String str1 = str2;
            if (str2 == null) {
                str1 = "";
            }
            setCookie("http://amazon-adsystem.com", "ad-id=" + str1 + "; Domain=.amazon-adsystem.com");
        }
    }

    public WebView createWebView(Context paramContext) {
        try {
            WebView localWebView = new WebView(paramContext);
            if (!this.cookieSyncManagerCreated) {
                CookieSyncManager.createInstance(paramContext);
                this.cookieSyncManagerCreated = true;
            }
            updateAdIdCookie();
            return localWebView;
        } finally {
        }
    }

    protected void setCookie(String paramString1, String paramString2) {
        CookieManager.getInstance().setCookie(paramString1, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/WebViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */