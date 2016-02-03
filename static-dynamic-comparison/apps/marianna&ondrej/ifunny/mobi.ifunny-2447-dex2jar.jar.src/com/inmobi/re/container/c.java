package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

class c
        extends WebChromeClient {
    c(IMWebView paramIMWebView) {
    }

    public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback) {
        try {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(IMWebView.i(this.a));
            localBuilder.setTitle("Locations access");
            localBuilder.setMessage("Allow location access").setCancelable(true).setPositiveButton("Accept", new c.j(this, paramCallback, paramString)).setNegativeButton("Decline", new c.i(this, paramCallback, paramString));
            localBuilder.create().show();
            super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception while accessing location from creative ", localException);
            paramCallback.invoke(paramString, false, false);
        }
    }

    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onJsAlert, " + paramString2);
        try {
            if ((this.a.isExpanded()) || (this.a.mIsInterstitialAd)) {
            }
            for (paramWebView = this.a.getExpandedActivity(); ; paramWebView = paramWebView.getContext()) {
                new AlertDialog.Builder(paramWebView).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, new c.b(this, paramJsResult)).setCancelable(false).create().show();
                break;
            }
            return true;
        } catch (Exception paramWebView) {
            Log.internal("[InMobi]-[RE]-4.5.1", "webchrome client exception onJSAlert ", paramWebView);
        }
    }

    public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView-> onJsConfirm, " + paramString2);
        try {
            if ((this.a.isExpanded()) || (this.a.mIsInterstitialAd)) {
            }
            for (paramWebView = this.a.getExpandedActivity(); ; paramWebView = paramWebView.getContext()) {
                paramWebView = new AlertDialog.Builder(paramWebView).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, new c.a(this, paramJsResult));
                paramWebView.setNegativeButton(17039360, new c.d(this, paramJsResult));
                paramWebView.setCancelable(false).create().show();
                break;
            }
            return true;
        } catch (Exception paramWebView) {
            Log.internal("[InMobi]-[RE]-4.5.1", "webchrome client exception onJSConfirm ", paramWebView);
        }
    }

    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
        IMWebView.a(this.a, paramView);
        IMWebView.a(this.a, paramCustomViewCallback);
        Log.debug("[InMobi]-[RE]-4.5.1", "onShowCustomView ******************************" + paramView);
        try {
            IMWebView.a(this.a, IMWebView.h(this.a), new c.c(this));
            IMWebView.h(this.a).setOnTouchListener(new c.g(this));
            if ((paramView instanceof FrameLayout)) {
                IMWebView.a(this.a, (FrameLayout) paramView);
                paramCustomViewCallback = (FrameLayout) IMWebView.i(this.a).findViewById(16908290);
                if ((IMWebView.j(this.a).getFocusedChild() instanceof VideoView)) {
                    IMWebView.a(this.a, (VideoView) IMWebView.j(this.a).getFocusedChild());
                    if ((this.a.isExpanded()) || (this.a.mIsInterstitialAd)) {
                    }
                    for (paramView = this.a.getExpandedActivity(); ; paramView = paramView.getContext()) {
                        IMWebView.k(this.a).setMediaController(new MediaController(paramView));
                        IMWebView.j(this.a).setBackgroundColor(-16777216);
                        IMWebView.k(this.a).setOnCompletionListener(IMWebView.l(this.a));
                        IMWebView.k(this.a).setOnFocusChangeListener(new c.h(this));
                        paramCustomViewCallback.addView(IMWebView.h(this.a), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
                        Log.debug("[InMobi]-[RE]-4.5.1", "Registering");
                        IMWebView.a(this.a, IMWebView.h(this.a), new c.e(this));
                        return;
                    }
                }
                IMWebView.a(this.a, paramView);
                paramView.setBackgroundColor(-16777216);
                Log.debug("[InMobi]-[RE]-4.5.1", "adding " + paramView);
                paramCustomViewCallback.addView(paramView, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
                IMWebView.a(this.a, IMWebView.h(this.a), new c.f(this));
                return;
            }
        } catch (Exception paramView) {
            Log.internal("[InMobi]-[RE]-4.5.1", "IMWebview onShowCustomView exception ", paramView);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */