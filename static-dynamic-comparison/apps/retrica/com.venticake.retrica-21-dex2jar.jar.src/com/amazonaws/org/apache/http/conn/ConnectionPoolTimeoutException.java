package com.amazonaws.org.apache.http.conn;

import org.apache.http.annotation.Immutable;

@Immutable
public class ConnectionPoolTimeoutException
  extends ConnectTimeoutException
{
  public ConnectionPoolTimeoutException() {}
  
  public ConnectionPoolTimeoutException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ConnectionPoolTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */