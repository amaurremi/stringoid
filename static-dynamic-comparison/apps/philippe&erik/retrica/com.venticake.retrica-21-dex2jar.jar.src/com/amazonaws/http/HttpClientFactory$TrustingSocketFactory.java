package com.amazonaws.http;

import com.amazonaws.org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import com.amazonaws.org.apache.http.conn.scheme.SchemeSocketFactory;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

class HttpClientFactory$TrustingSocketFactory
  implements SchemeLayeredSocketFactory, SchemeSocketFactory
{
  private SSLContext sslcontext = null;
  
  private static SSLContext createSSLContext()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { new HttpClientFactory.TrustingX509TrustManager(null) }, null);
      return localSSLContext;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.getMessage(), localException);
    }
  }
  
  private SSLContext getSSLContext()
  {
    if (this.sslcontext == null) {
      this.sslcontext = createSSLContext();
    }
    return this.sslcontext;
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams)
  {
    int i = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
    int j = HttpConnectionParams.getSoTimeout(paramHttpParams);
    if (paramSocket != null) {}
    for (;;)
    {
      paramSocket = (SSLSocket)paramSocket;
      if (paramInetSocketAddress2 != null) {
        paramSocket.bind(paramInetSocketAddress2);
      }
      paramSocket.connect(paramInetSocketAddress1, i);
      paramSocket.setSoTimeout(j);
      return paramSocket;
      paramSocket = createSocket(paramHttpParams);
    }
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpParams paramHttpParams)
  {
    return getSSLContext().getSocketFactory().createSocket(paramSocket, paramString, paramInt, true);
  }
  
  public Socket createSocket(HttpParams paramHttpParams)
  {
    return getSSLContext().getSocketFactory().createSocket();
  }
  
  public boolean isSecure(Socket paramSocket)
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpClientFactory$TrustingSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */