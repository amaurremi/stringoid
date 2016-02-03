package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.net.InetAddress;

public abstract interface ClientConnectionOperator
{
  public abstract OperatedClientConnection createConnection();
  
  public abstract void openConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, InetAddress paramInetAddress, HttpContext paramHttpContext, HttpParams paramHttpParams);
  
  public abstract void updateSecureConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext, HttpParams paramHttpParams);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ClientConnectionOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */