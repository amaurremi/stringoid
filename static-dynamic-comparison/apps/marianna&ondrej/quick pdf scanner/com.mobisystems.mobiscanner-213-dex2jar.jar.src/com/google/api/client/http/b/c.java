package com.google.api.client.http.b;

import com.google.api.client.http.w;
import com.google.api.client.util.x;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class c
  extends w
{
  private static final String[] abO = { "DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE" };
  private final Proxy acl;
  private final SSLSocketFactory acm;
  private final HostnameVerifier hostnameVerifier;
  
  static
  {
    Arrays.sort(abO);
  }
  
  public c()
  {
    this(null, null, null);
  }
  
  c(Proxy paramProxy, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier)
  {
    this.acl = paramProxy;
    this.acm = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
  }
  
  public boolean cj(String paramString)
  {
    return Arrays.binarySearch(abO, paramString) >= 0;
  }
  
  protected a n(String paramString1, String paramString2)
  {
    x.b(cj(paramString1), "HTTP method %s not supported", new Object[] { paramString1 });
    paramString2 = new URL(paramString2);
    if (this.acl == null) {}
    for (paramString2 = paramString2.openConnection();; paramString2 = paramString2.openConnection(this.acl))
    {
      paramString2 = (HttpURLConnection)paramString2;
      paramString2.setRequestMethod(paramString1);
      if ((paramString2 instanceof HttpsURLConnection))
      {
        paramString1 = (HttpsURLConnection)paramString2;
        if (this.hostnameVerifier != null) {
          paramString1.setHostnameVerifier(this.hostnameVerifier);
        }
        if (this.acm != null) {
          paramString1.setSSLSocketFactory(this.acm);
        }
      }
      return new a(paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */