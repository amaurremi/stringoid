package com.google.api.client.http.a;

import com.google.api.client.http.w;
import java.net.ProxySelector;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class c
  extends w
{
  private final HttpClient lq;
  
  public c()
  {
    this(yc());
  }
  
  public c(HttpClient paramHttpClient)
  {
    this.lq = paramHttpClient;
    paramHttpClient = paramHttpClient.getParams();
    HttpProtocolParams.setVersion(paramHttpClient, HttpVersion.HTTP_1_1);
    paramHttpClient.setBooleanParameter("http.protocol.handle-redirects", false);
  }
  
  static DefaultHttpClient a(SSLSocketFactory paramSSLSocketFactory, HttpParams paramHttpParams, ProxySelector paramProxySelector)
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", paramSSLSocketFactory, 443));
    paramSSLSocketFactory = new DefaultHttpClient(new ThreadSafeClientConnManager(paramHttpParams, localSchemeRegistry), paramHttpParams);
    paramSSLSocketFactory.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
    if (paramProxySelector != null) {
      paramSSLSocketFactory.setRoutePlanner(new ProxySelectorRoutePlanner(localSchemeRegistry, paramProxySelector));
    }
    return paramSSLSocketFactory;
  }
  
  public static DefaultHttpClient yc()
  {
    return a(SSLSocketFactory.getSocketFactory(), yd(), ProxySelector.getDefault());
  }
  
  static HttpParams yd()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 200);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(20));
    return localBasicHttpParams;
  }
  
  public boolean cj(String paramString)
  {
    return true;
  }
  
  protected a m(String paramString1, String paramString2)
  {
    if (paramString1.equals("DELETE")) {
      paramString1 = new HttpDelete(paramString2);
    }
    for (;;)
    {
      return new a(this.lq, paramString1);
      if (paramString1.equals("GET")) {
        paramString1 = new HttpGet(paramString2);
      } else if (paramString1.equals("HEAD")) {
        paramString1 = new HttpHead(paramString2);
      } else if (paramString1.equals("POST")) {
        paramString1 = new HttpPost(paramString2);
      } else if (paramString1.equals("PUT")) {
        paramString1 = new HttpPut(paramString2);
      } else if (paramString1.equals("TRACE")) {
        paramString1 = new HttpTrace(paramString2);
      } else if (paramString1.equals("OPTIONS")) {
        paramString1 = new HttpOptions(paramString2);
      } else {
        paramString1 = new e(paramString1, paramString2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */