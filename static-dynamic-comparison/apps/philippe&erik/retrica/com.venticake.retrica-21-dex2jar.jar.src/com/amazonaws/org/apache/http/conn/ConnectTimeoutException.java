package com.amazonaws.org.apache.http.conn;

import java.io.InterruptedIOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class ConnectTimeoutException
  extends InterruptedIOException
{
  public ConnectTimeoutException() {}
  
  public ConnectTimeoutException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ConnectTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */