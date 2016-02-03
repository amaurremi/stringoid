package com.flurry.android;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

final class cv
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext eV = SSLContext.getInstance("TLS");
  
  public cv(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    paramKeyStore = new n();
    this.eV.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public final Socket createSocket()
    throws IOException
  {
    return this.eV.getSocketFactory().createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this.eV.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */