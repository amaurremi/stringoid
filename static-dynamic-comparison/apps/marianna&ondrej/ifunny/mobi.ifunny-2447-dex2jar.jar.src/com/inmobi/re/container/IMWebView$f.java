package com.inmobi.re.container;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class IMWebView$f
        implements DialogInterface.OnClickListener {
    IMWebView$f(IMWebView paramIMWebView, SslErrorHandler paramSslErrorHandler) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface.cancel();
        this.a.cancel();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */