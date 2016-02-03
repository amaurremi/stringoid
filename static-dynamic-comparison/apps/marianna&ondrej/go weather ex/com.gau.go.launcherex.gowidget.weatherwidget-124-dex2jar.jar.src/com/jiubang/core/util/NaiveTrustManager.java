package com.jiubang.core.util;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class NaiveTrustManager
  implements X509TrustManager
{
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/NaiveTrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */