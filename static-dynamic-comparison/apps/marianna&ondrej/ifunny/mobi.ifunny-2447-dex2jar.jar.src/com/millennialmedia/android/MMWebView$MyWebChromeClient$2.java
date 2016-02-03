package com.millennialmedia.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;

class MMWebView$MyWebChromeClient$2
        implements DialogInterface.OnClickListener {
    MMWebView$MyWebChromeClient$2(MMWebView.MyWebChromeClient paramMyWebChromeClient, GeolocationPermissions.Callback paramCallback, String paramString) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        MMWebView.MyWebChromeClient.a(this.c, true);
        this.a.invoke(this.b, true, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$MyWebChromeClient$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */