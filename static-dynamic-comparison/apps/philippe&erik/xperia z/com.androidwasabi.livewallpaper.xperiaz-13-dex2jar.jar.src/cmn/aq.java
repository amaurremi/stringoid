package cmn;

import org.apache.http.HttpVersion;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class aq
{
  private static DefaultHttpClient a;
  private static SSLSocketFactory b = ;
  
  public static DefaultHttpClient a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = new BasicHttpParams();
        ConnManagerParams.setMaxTotalConnections((HttpParams)localObject1, 10);
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, 30000);
        HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject1, false);
        HttpConnectionParams.setSocketBufferSize((HttpParams)localObject1, 8192);
        HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent((HttpParams)localObject1, "Apache-HttpClient/UNAVAILABLE (java 1.4; SCM)");
        HttpClientParams.setRedirecting((HttpParams)localObject1, true);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", b, 443));
        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject1, localSchemeRegistry), (HttpParams)localObject1);
        ((DefaultHttpClient)localObject1).getParams().setParameter("http.socket.timeout", Integer.valueOf(30000));
        ((DefaultHttpClient)localObject1).getParams().setParameter("http.connection.timeout", Integer.valueOf(30000));
        ((DefaultHttpClient)localObject1).getParams().setParameter("http.useragent", "Apache-HttpClient/UNAVAILABLE (java 1.4; SCM)");
        ((DefaultHttpClient)localObject1).getParams().setParameter("http.protocol.expect-continue", Boolean.valueOf(false));
        a = (DefaultHttpClient)localObject1;
      }
      Object localObject1 = a;
      return (DefaultHttpClient)localObject1;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */