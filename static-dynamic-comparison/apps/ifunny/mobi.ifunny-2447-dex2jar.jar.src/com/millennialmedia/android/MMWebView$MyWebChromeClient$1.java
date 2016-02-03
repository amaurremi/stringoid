package com.millennialmedia.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;

class MMWebView$MyWebChromeClient$1
        implements DialogInterface.OnClickListener {
    MMWebView$MyWebChromeClient$1(MMWebView.MyWebChromeClient paramMyWebChromeClient, GeolocationPermissions.Callback paramCallback, String paramString) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        MMWebView.MyWebChromeClient.a(this.c, false);
        this.a.invoke(this.b, false, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$MyWebChromeClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */