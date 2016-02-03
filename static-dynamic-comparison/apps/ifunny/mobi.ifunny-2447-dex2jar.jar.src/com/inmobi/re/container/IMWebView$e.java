package com.inmobi.re.container;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class IMWebView$e
        implements DialogInterface.OnClickListener {
    IMWebView$e(IMWebView paramIMWebView, SslErrorHandler paramSslErrorHandler) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface.cancel();
        this.a.proceed();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */