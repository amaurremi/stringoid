package com.flurry.android;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

final class ai
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a = SSLContext.getInstance("TLS");
  
  public ai(FlurryAgent paramFlurryAgent, KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    paramFlurryAgent = new n();
    this.a.init(null, new TrustManager[] { paramFlurryAgent }, null);
  }
  
  public final Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */