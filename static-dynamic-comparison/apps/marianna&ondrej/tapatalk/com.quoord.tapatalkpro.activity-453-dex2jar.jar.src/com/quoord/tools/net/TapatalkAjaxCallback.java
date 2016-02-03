package com.quoord.tools.net;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;

import java.security.KeyStore;

import org.apache.http.conn.ssl.SSLSocketFactory;

public class TapatalkAjaxCallback<T>
        extends AjaxCallback<T> {
    private static int timeOutSeconds = 10;

    public TapatalkAjaxCallback() {
        try {
            MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            localMySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            new AjaxCallback() {
                public void callback(String paramAnonymousString, T paramAnonymousT, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousT, paramAnonymousAjaxStatus);
                }
            };
            AjaxCallback.setSSF(localMySSLSocketFactory);
            AjaxCallback.setTimeout(timeOutSeconds * 1000);
            return;
        } catch (Exception localException) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/TapatalkAjaxCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */