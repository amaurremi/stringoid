package com.everimaging.fotorsdk.http;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class i
        extends org.apache.http.conn.ssl.SSLSocketFactory {
    SSLContext a = SSLContext.getInstance("TLS");

    public i(KeyStore paramKeyStore)
            throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(paramKeyStore);
        paramKeyStore = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
                    throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
                    throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        this.a.init(null, new TrustManager[]{paramKeyStore}, null);
    }

    public static KeyStore a() {
        try {
            localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            localThrowable1.printStackTrace();
        } catch (Throwable localThrowable1) {
            try {
                localKeyStore.load(null, null);
                return localKeyStore;
            } catch (Throwable localThrowable2) {
                KeyStore localKeyStore;
                for (; ; ) {
                }
            }
            localThrowable1 = localThrowable1;
            localKeyStore = null;
        }
        return localKeyStore;
    }

    public static org.apache.http.conn.ssl.SSLSocketFactory b() {
        try {
            i locali = new i(a());
            locali.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return locali;
        } catch (Throwable localThrowable) {
            localThrowable.printStackTrace();
        }
        return org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    }

    public Socket createSocket()
            throws IOException {
        return this.a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
            throws IOException {
        return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */