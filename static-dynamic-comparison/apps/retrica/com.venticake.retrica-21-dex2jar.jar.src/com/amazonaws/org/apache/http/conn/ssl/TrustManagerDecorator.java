package com.amazonaws.org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class TrustManagerDecorator
  implements X509TrustManager
{
  private final X509TrustManager trustManager;
  private final TrustStrategy trustStrategy;
  
  TrustManagerDecorator(X509TrustManager paramX509TrustManager, TrustStrategy paramTrustStrategy)
  {
    this.trustManager = paramX509TrustManager;
    this.trustStrategy = paramTrustStrategy;
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.trustManager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (!this.trustStrategy.isTrusted(paramArrayOfX509Certificate, paramString)) {
      this.trustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.trustManager.getAcceptedIssuers();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ssl/TrustManagerDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */