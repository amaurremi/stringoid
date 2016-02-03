package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.impl.client.HttpRequestNoRetryHandler;
import com.amazonaws.http.impl.client.SdkHttpClient;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.auth.AuthScope;
import com.amazonaws.org.apache.http.auth.NTCredentials;
import com.amazonaws.org.apache.http.client.CredentialsProvider;
import com.amazonaws.org.apache.http.client.HttpClient;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.params.ConnRouteParams;
import com.amazonaws.org.apache.http.conn.scheme.PlainSocketFactory;
import com.amazonaws.org.apache.http.conn.scheme.Scheme;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.conn.ssl.SSLSocketFactory;
import com.amazonaws.org.apache.http.impl.conn.PoolingClientConnectionManager;
import com.amazonaws.org.apache.http.params.BasicHttpParams;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.commons.logging.Log;

class HttpClientFactory
{
  public HttpClient createHttpClient(ClientConfiguration paramClientConfiguration)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, paramClientConfiguration.getConnectionTimeout());
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, paramClientConfiguration.getSocketTimeout());
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, true);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    int i = paramClientConfiguration.getSocketBufferSizeHints()[0];
    int j = paramClientConfiguration.getSocketBufferSizeHints()[1];
    if ((i > 0) || (j > 0)) {
      HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, Math.max(i, j));
    }
    Object localObject1 = ConnectionManagerFactory.createPoolingClientConnManager(paramClientConfiguration, (HttpParams)localObject2);
    SdkHttpClient localSdkHttpClient = new SdkHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
    localSdkHttpClient.setHttpRequestRetryHandler(HttpRequestNoRetryHandler.Singleton);
    localSdkHttpClient.setRedirectStrategy(new HttpClientFactory.LocationHeaderNotRequiredRedirectStrategy(null));
    if (paramClientConfiguration.getLocalAddress() != null) {
      ConnRouteParams.setLocalAddress((HttpParams)localObject2, paramClientConfiguration.getLocalAddress());
    }
    try
    {
      localObject2 = new Scheme("http", 80, PlainSocketFactory.getSocketFactory());
      Object localObject3 = new Scheme("https", 443, new SSLSocketFactory(SSLContext.getDefault(), SSLSocketFactory.STRICT_HOSTNAME_VERIFIER));
      localObject1 = ((PoolingClientConnectionManager)localObject1).getSchemeRegistry();
      ((SchemeRegistry)localObject1).register((Scheme)localObject2);
      ((SchemeRegistry)localObject1).register((Scheme)localObject3);
      localObject1 = new Scheme("https", 443, new HttpClientFactory.TrustingSocketFactory(null));
      localSdkHttpClient.getConnectionManager().getSchemeRegistry().register((Scheme)localObject1);
      localObject1 = paramClientConfiguration.getProxyHost();
      i = paramClientConfiguration.getProxyPort();
      if ((localObject1 != null) && (i > 0))
      {
        AmazonHttpClient.log.info("Configuring Proxy. Proxy Host: " + (String)localObject1 + " " + "Proxy Port: " + i);
        localObject2 = new HttpHost((String)localObject1, i);
        localSdkHttpClient.getParams().setParameter("http.route.default-proxy", localObject2);
        localObject3 = paramClientConfiguration.getProxyUsername();
        String str1 = paramClientConfiguration.getProxyPassword();
        String str2 = paramClientConfiguration.getProxyDomain();
        String str3 = paramClientConfiguration.getProxyWorkstation();
        if ((localObject3 != null) && (str1 != null)) {
          localSdkHttpClient.getCredentialsProvider().setCredentials(new AuthScope((String)localObject1, i), new NTCredentials((String)localObject3, str1, str3, str2));
        }
        if (paramClientConfiguration.isPreemptiveBasicProxyAuth()) {
          localSdkHttpClient.addRequestInterceptor(new HttpClientFactory.PreemptiveProxyAuth((HttpHost)localObject2), 0);
        }
      }
      return localSdkHttpClient;
    }
    catch (NoSuchAlgorithmException paramClientConfiguration)
    {
      throw new AmazonClientException("Unable to access default SSL context", paramClientConfiguration);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */