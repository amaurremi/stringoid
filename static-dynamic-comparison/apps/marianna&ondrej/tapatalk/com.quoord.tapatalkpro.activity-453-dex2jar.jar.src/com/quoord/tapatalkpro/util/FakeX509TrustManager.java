package com.quoord.tapatalkpro.util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class FakeX509TrustManager
        implements X509TrustManager {
    private static final X509Certificate[] _AcceptedIssuers = new X509Certificate[0];
    private static TrustManager[] trustManagers;

    public static void allowAllSSL() {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession) {
                return true;
            }
        });
        Object localObject2 = null;
        Object localObject1 = null;
        if (trustManagers == null) {
            trustManagers = new TrustManager[]{new FakeX509TrustManager()};
        }
        try {
            SSLContext localSSLContext = SSLContext.getInstance("TLS");
            localObject1 = localSSLContext;
            localObject2 = localSSLContext;
            localSSLContext.init(null, trustManagers, new SecureRandom());
            localObject1 = localSSLContext;
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException2) {
            for (; ; ) {
                localNoSuchAlgorithmException2.printStackTrace();
            }
        } catch (KeyManagementException localKeyManagementException) {
            for (; ; ) {
                localKeyManagementException.printStackTrace();
                NoSuchAlgorithmException localNoSuchAlgorithmException1 = localNoSuchAlgorithmException2;
            }
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext) localObject1).getSocketFactory());
    }

    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
            throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
            throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return _AcceptedIssuers;
    }

    public boolean isClientTrusted(X509Certificate[] paramArrayOfX509Certificate) {
        return true;
    }

    public boolean isServerTrusted(X509Certificate[] paramArrayOfX509Certificate) {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/FakeX509TrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */