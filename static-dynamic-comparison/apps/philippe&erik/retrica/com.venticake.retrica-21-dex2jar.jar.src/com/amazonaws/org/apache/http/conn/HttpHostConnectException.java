package com.amazonaws.org.apache.http.conn;

import com.amazonaws.org.apache.http.HttpHost;
import java.net.ConnectException;
import org.apache.http.annotation.Immutable;

@Immutable
public class HttpHostConnectException
  extends ConnectException
{
  private final HttpHost host;
  
  public HttpHostConnectException(HttpHost paramHttpHost, ConnectException paramConnectException)
  {
    super("Connection to " + paramHttpHost + " refused");
    this.host = paramHttpHost;
    initCause(paramConnectException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/HttpHostConnectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */