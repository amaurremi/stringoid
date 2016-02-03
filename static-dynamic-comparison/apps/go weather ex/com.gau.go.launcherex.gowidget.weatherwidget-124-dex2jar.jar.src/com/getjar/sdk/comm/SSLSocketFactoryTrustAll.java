package com.getjar.sdk.comm;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SSLSocketFactoryTrustAll
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private static final X509HostnameVerifier _HostnameVerifier = new X509HostnameVerifier()
  {
    public void verify(String paramAnonymousString, X509Certificate paramAnonymousX509Certificate)
      throws SSLException
    {}
    
    public void verify(String paramAnonymousString, SSLSocket paramAnonymousSSLSocket)
      throws IOException
    {}
    
    public void verify(String paramAnonymousString, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2)
      throws SSLException
    {}
    
    public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
    {
      return true;
    }
  };
  private static final TrustManager[] _TrustAllCerts = { new X509TrustManager()
  {
    public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
    
    public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  } };
  private SSLContext _sslContext = SSLContext.getInstance("TLS");
  
  public SSLSocketFactoryTrustAll(KeyStore paramKeyStore)
    throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    this._sslContext.init(null, _TrustAllCerts, null);
    setHostnameVerifier(_HostnameVerifier);
  }
  
  public Socket createSocket()
    throws IOException
  {
    return this._sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this._sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/SSLSocketFactoryTrustAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */