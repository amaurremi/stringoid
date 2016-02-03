package com.millennialmedia.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

class MMWebView$MyWebChromeClient
        extends WebChromeClient {
    WeakReference<MMWebView> a;

    MMWebView$MyWebChromeClient(MMWebView paramMMWebView) {
        this.a = new WeakReference(paramMMWebView);
    }

    private String a(Context paramContext) {
        PackageManager localPackageManager = paramContext.getApplicationContext().getPackageManager();
        try {
            paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
            if (paramContext != null) {
                paramContext = localPackageManager.getApplicationLabel(paramContext);
                return (String) paramContext;
            }
        } catch (PackageManager.NameNotFoundException paramContext) {
            for (; ; ) {
                paramContext = null;
                continue;
                paramContext = "This app";
            }
        }
    }

    private void a(boolean paramBoolean) {
        Object localObject = (MMWebView) this.a.get();
        if (localObject != null) {
            localObject = ((MMWebView) localObject).getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
            ((SharedPreferences.Editor) localObject).putBoolean("mm_use_geo_location", paramBoolean);
            ((SharedPreferences.Editor) localObject).commit();
        }
    }

    private boolean a() {
        MMWebView localMMWebView = (MMWebView) this.a.get();
        if (localMMWebView != null) {
            return !localMMWebView.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location");
        }
        return false;
    }

    private boolean b() {
        MMWebView localMMWebView = (MMWebView) this.a.get();
        if (localMMWebView != null) {
            return localMMWebView.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
        }
        return false;
    }

    public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {
        super.onConsoleMessage(paramString1, paramInt, paramString2);
    }

    public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback) {
        if (a()) {
            if (b()) {
                paramCallback.invoke(paramString, true, true);
            }
            Object localObject;
            do {
                do {
                    return;
                    localObject = (MMWebView) this.a.get();
                } while (localObject == null);
                localObject = ((MMWebView) localObject).i();
            } while (localObject == null);
            AlertDialog.Builder localBuilder = new AlertDialog.Builder((Context) localObject);
            localBuilder.setTitle(a((Context) localObject));
            localBuilder.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new MMWebView.MyWebChromeClient
            .2 (this, paramCallback, paramString)).setNegativeButton("Don't Allow", new MMWebView.MyWebChromeClient .1
            (this, paramCallback, paramString));
            localBuilder.create().show();
            return;
        }
        paramCallback.invoke(paramString, false, false);
    }

    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        MMWebView localMMWebView = (MMWebView) this.a.get();
        if (localMMWebView != null) {
            if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
                return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
            }
            Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
        }
        return true;
    }

    public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        MMWebView localMMWebView = (MMWebView) this.a.get();
        if (localMMWebView != null) {
            if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
                return super.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
            }
            Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
        }
        return true;
    }

    public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        MMWebView localMMWebView = (MMWebView) this.a.get();
        if (localMMWebView != null) {
            if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
                return super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
            }
            Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
        }
        return true;
    }

    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
        MMWebView localMMWebView = (MMWebView) this.a.get();
        if (localMMWebView != null) {
            if (localMMWebView.getContext() != localMMWebView.getContext().getApplicationContext()) {
                return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
            }
            Toast.makeText(localMMWebView.getContext(), paramString2, 0).show();
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$MyWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */