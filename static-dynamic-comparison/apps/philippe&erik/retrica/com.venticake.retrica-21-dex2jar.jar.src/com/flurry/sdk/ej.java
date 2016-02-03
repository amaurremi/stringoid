package com.flurry.sdk;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class ej
  implements X509TrustManager
{
  private X509TrustManager a = null;
  
  public ej(KeyStore paramKeyStore)
  {
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(paramKeyStore);
    paramKeyStore = localTrustManagerFactory.getTrustManagers();
    if (paramKeyStore.length == 0) {
      throw new NoSuchAlgorithmException("no trust manager found");
    }
    this.a = ((X509TrustManager)paramKeyStore[0]);
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length == 1))
    {
      paramArrayOfX509Certificate[0].checkValidity();
      return;
    }
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */