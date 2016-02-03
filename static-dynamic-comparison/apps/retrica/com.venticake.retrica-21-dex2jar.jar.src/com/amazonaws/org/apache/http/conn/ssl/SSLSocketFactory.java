package com.amazonaws.org.apache.http.conn.ssl;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.conn.ConnectTimeoutException;
import com.amazonaws.org.apache.http.conn.HttpInetSocketAddress;
import com.amazonaws.org.apache.http.conn.scheme.HostNameResolver;
import com.amazonaws.org.apache.http.conn.scheme.LayeredSchemeSocketFactory;
import com.amazonaws.org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class SSLSocketFactory
  implements LayeredSchemeSocketFactory, SchemeLayeredSocketFactory
{
  public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
  public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
  private static final char[] EMPTY_PASSWORD = "".toCharArray();
  public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
  private volatile X509HostnameVerifier hostnameVerifier;
  private final HostNameResolver nameResolver;
  private final javax.net.ssl.SSLSocketFactory socketfactory;
  
  public SSLSocketFactory(SSLContext paramSSLContext)
  {
    this(paramSSLContext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(SSLContext paramSSLContext, X509HostnameVerifier paramX509HostnameVerifier)
  {
    if (paramSSLContext == null) {
      throw new IllegalArgumentException("SSL context may not be null");
    }
    this.socketfactory = paramSSLContext.getSocketFactory();
    this.hostnameVerifier = paramX509HostnameVerifier;
    this.nameResolver = null;
  }
  
  private static SSLContext createDefaultSSLContext()
  {
    try
    {
      SSLContext localSSLContext = createSSLContext("TLS", null, null, null, null, null);
      return localSSLContext;
    }
    catch (Exception localException)
    {
      throw new SSLInitializationException("Failure initializing default SSL context", localException);
    }
  }
  
  private static SSLContext createSSLContext(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, TrustStrategy paramTrustStrategy)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "TLS";
    }
    KeyManagerFactory localKeyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    if (paramString2 != null) {}
    for (paramString1 = paramString2.toCharArray();; paramString1 = null)
    {
      localKeyManagerFactory.init(paramKeyStore1, paramString1);
      paramString1 = localKeyManagerFactory.getKeyManagers();
      paramKeyStore1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      paramKeyStore1.init(paramKeyStore2);
      paramKeyStore1 = paramKeyStore1.getTrustManagers();
      if ((paramKeyStore1 == null) || (paramTrustStrategy == null)) {
        break;
      }
      int i = 0;
      while (i < paramKeyStore1.length)
      {
        paramString2 = paramKeyStore1[i];
        if ((paramString2 instanceof X509TrustManager)) {
          paramKeyStore1[i] = new TrustManagerDecorator((X509TrustManager)paramString2, paramTrustStrategy);
        }
        i += 1;
      }
    }
    paramString2 = SSLContext.getInstance(str);
    paramString2.init(paramString1, paramKeyStore1, paramSecureRandom);
    return paramString2;
  }
  
  public static SSLSocketFactory getSocketFactory()
  {
    return new SSLSocketFactory(createDefaultSSLContext());
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams)
  {
    if (paramInetSocketAddress1 == null) {
      throw new IllegalArgumentException("Remote address may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    int i;
    int j;
    if (paramSocket != null)
    {
      if (paramInetSocketAddress2 != null)
      {
        paramSocket.setReuseAddress(HttpConnectionParams.getSoReuseaddr(paramHttpParams));
        paramSocket.bind(paramInetSocketAddress2);
      }
      i = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
      j = HttpConnectionParams.getSoTimeout(paramHttpParams);
    }
    for (;;)
    {
      try
      {
        paramSocket.setSoTimeout(j);
        paramSocket.connect(paramInetSocketAddress1, i);
        if ((paramInetSocketAddress1 instanceof HttpInetSocketAddress))
        {
          paramInetSocketAddress2 = ((HttpInetSocketAddress)paramInetSocketAddress1).getHttpHost().getHostName();
          if (!(paramSocket instanceof SSLSocket)) {
            break label180;
          }
          paramSocket = (SSLSocket)paramSocket;
          if (this.hostnameVerifier == null) {}
        }
      }
      catch (SocketTimeoutException paramSocket)
      {
        throw new ConnectTimeoutException("Connect to " + paramInetSocketAddress1 + " timed out");
      }
      try
      {
        this.hostnameVerifier.verify(paramInetSocketAddress2, paramSocket);
        return paramSocket;
      }
      catch (IOException paramInetSocketAddress1) {}
      paramSocket = this.socketfactory.createSocket();
      break;
      paramInetSocketAddress2 = paramInetSocketAddress1.getHostName();
      continue;
      label180:
      i = paramInetSocketAddress1.getPort();
      paramSocket = (SSLSocket)this.socketfactory.createSocket(paramSocket, paramInetSocketAddress2, i, true);
      prepareSocket(paramSocket);
    }
    try
    {
      paramSocket.close();
      throw paramInetSocketAddress1;
    }
    catch (Exception paramSocket)
    {
      for (;;) {}
    }
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpParams paramHttpParams)
  {
    paramSocket = (SSLSocket)this.socketfactory.createSocket(paramSocket, paramString, paramInt, true);
    prepareSocket(paramSocket);
    if (this.hostnameVerifier != null) {
      this.hostnameVerifier.verify(paramString, paramSocket);
    }
    return paramSocket;
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = (SSLSocket)this.socketfactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    prepareSocket(paramSocket);
    if (this.hostnameVerifier != null) {
      this.hostnameVerifier.verify(paramString, paramSocket);
    }
    return paramSocket;
  }
  
  public Socket createSocket(HttpParams paramHttpParams)
  {
    paramHttpParams = (SSLSocket)this.socketfactory.createSocket();
    prepareSocket(paramHttpParams);
    return paramHttpParams;
  }
  
  public boolean isSecure(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null");
    }
    if (!(paramSocket instanceof SSLSocket)) {
      throw new IllegalArgumentException("Socket not created by this factory");
    }
    if (paramSocket.isClosed()) {
      throw new IllegalArgumentException("Socket is closed");
    }
    return true;
  }
  
  protected void prepareSocket(SSLSocket paramSSLSocket) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ssl/SSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */