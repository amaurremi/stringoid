package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpHost;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class HttpInetSocketAddress
  extends InetSocketAddress
{
  private final HttpHost httphost;
  
  public HttpInetSocketAddress(HttpHost paramHttpHost, InetAddress paramInetAddress, int paramInt)
  {
    super(paramInetAddress, paramInt);
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("HTTP host may not be null");
    }
    this.httphost = paramHttpHost;
  }
  
  public HttpHost getHttpHost()
  {
    return this.httphost;
  }
  
  public String toString()
  {
    return this.httphost.getHostName() + ":" + getPort();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/HttpInetSocketAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */