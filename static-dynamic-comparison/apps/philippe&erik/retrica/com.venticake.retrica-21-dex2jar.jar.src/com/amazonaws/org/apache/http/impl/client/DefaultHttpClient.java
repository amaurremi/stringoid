package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.client.protocol.RequestAddCookies;
import com.amazonaws.org.apache.http.client.protocol.RequestAuthCache;
import com.amazonaws.org.apache.http.client.protocol.RequestClientConnControl;
import com.amazonaws.org.apache.http.client.protocol.RequestDefaultHeaders;
import com.amazonaws.org.apache.http.client.protocol.RequestProxyAuthentication;
import com.amazonaws.org.apache.http.client.protocol.RequestTargetAuthentication;
import com.amazonaws.org.apache.http.client.protocol.ResponseProcessCookies;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import com.amazonaws.org.apache.http.params.SyncBasicHttpParams;
import com.amazonaws.org.apache.http.protocol.BasicHttpProcessor;
import com.amazonaws.org.apache.http.protocol.HTTP;
import com.amazonaws.org.apache.http.protocol.RequestContent;
import com.amazonaws.org.apache.http.protocol.RequestExpectContinue;
import com.amazonaws.org.apache.http.protocol.RequestTargetHost;
import com.amazonaws.org.apache.http.protocol.RequestUserAgent;
import com.amazonaws.org.apache.http.util.VersionInfo;
import java.nio.charset.Charset;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class DefaultHttpClient
  extends AbstractHttpClient
{
  public DefaultHttpClient()
  {
    super(null, null);
  }
  
  public DefaultHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  public static void setDefaultHttpParams(HttpParams paramHttpParams)
  {
    HttpProtocolParams.setVersion(paramHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(paramHttpParams, HTTP.DEF_CONTENT_CHARSET.name());
    HttpConnectionParams.setTcpNoDelay(paramHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(paramHttpParams, 8192);
    Object localObject = VersionInfo.loadVersionInfo("com.amazonaws.org.apache.http.client", DefaultHttpClient.class.getClassLoader());
    if (localObject != null) {}
    for (localObject = ((VersionInfo)localObject).getRelease();; localObject = "UNAVAILABLE")
    {
      HttpProtocolParams.setUserAgent(paramHttpParams, "Apache-HttpClient/" + (String)localObject + " (java 1.5)");
      return;
    }
  }
  
  protected HttpParams createHttpParams()
  {
    SyncBasicHttpParams localSyncBasicHttpParams = new SyncBasicHttpParams();
    setDefaultHttpParams(localSyncBasicHttpParams);
    return localSyncBasicHttpParams;
  }
  
  protected BasicHttpProcessor createHttpProcessor()
  {
    BasicHttpProcessor localBasicHttpProcessor = new BasicHttpProcessor();
    localBasicHttpProcessor.addInterceptor(new RequestDefaultHeaders());
    localBasicHttpProcessor.addInterceptor(new RequestContent());
    localBasicHttpProcessor.addInterceptor(new RequestTargetHost());
    localBasicHttpProcessor.addInterceptor(new RequestClientConnControl());
    localBasicHttpProcessor.addInterceptor(new RequestUserAgent());
    localBasicHttpProcessor.addInterceptor(new RequestExpectContinue());
    localBasicHttpProcessor.addInterceptor(new RequestAddCookies());
    localBasicHttpProcessor.addInterceptor(new ResponseProcessCookies());
    localBasicHttpProcessor.addInterceptor(new RequestAuthCache());
    localBasicHttpProcessor.addInterceptor(new RequestTargetAuthentication());
    localBasicHttpProcessor.addInterceptor(new RequestProxyAuthentication());
    return localBasicHttpProcessor;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */