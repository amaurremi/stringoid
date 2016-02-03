package com.amazonaws.org.apache.http.conn.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;

public abstract interface X509HostnameVerifier
  extends HostnameVerifier
{
  public abstract void verify(String paramString, SSLSocket paramSSLSocket);
  
  public abstract void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ssl/X509HostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */