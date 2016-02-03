package com.amazonaws.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class HttpClientFactory$TrustingX509TrustManager
  implements X509TrustManager
{
  private static final X509Certificate[] X509_CERTIFICATES = new X509Certificate[0];
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return X509_CERTIFICATES;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpClientFactory$TrustingX509TrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */