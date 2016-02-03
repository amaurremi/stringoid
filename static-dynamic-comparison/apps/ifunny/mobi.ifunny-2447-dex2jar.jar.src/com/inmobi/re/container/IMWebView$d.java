package com.inmobi.re.container;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import com.inmobi.commons.internal.WrapperFunctions;

class IMWebView$d
        implements DialogInterface.OnClickListener {
    IMWebView$d(IMWebView paramIMWebView, SslError paramSslError) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface.cancel();
        IMWebView.a(this.b, WrapperFunctions.getSSLErrorUrl(this.a));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */