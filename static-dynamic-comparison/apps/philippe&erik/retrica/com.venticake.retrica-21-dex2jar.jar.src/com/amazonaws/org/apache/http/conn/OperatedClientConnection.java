package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpClientConnection;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpInetConnection;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.Socket;

public abstract interface OperatedClientConnection
  extends HttpClientConnection, HttpInetConnection
{
  public abstract Socket getSocket();
  
  public abstract boolean isSecure();
  
  public abstract void openCompleted(boolean paramBoolean, HttpParams paramHttpParams);
  
  public abstract void opening(Socket paramSocket, HttpHost paramHttpHost);
  
  public abstract void update(Socket paramSocket, HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/OperatedClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */