package com.amazonaws.org.apache.http.conn.scheme;

import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract interface SchemeSocketFactory
{
  public abstract Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams);
  
  public abstract Socket createSocket(HttpParams paramHttpParams);
  
  public abstract boolean isSecure(Socket paramSocket);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/scheme/SchemeSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */