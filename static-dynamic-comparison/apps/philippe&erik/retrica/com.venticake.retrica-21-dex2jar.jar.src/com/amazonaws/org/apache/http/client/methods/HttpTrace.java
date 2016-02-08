package com.amazonaws.org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpTrace
  extends HttpRequestBase
{
  public HttpTrace() {}
  
  public HttpTrace(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "TRACE";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/HttpTrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */