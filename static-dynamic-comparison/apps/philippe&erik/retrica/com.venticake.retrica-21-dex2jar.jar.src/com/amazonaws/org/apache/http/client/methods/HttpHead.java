package com.amazonaws.org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpHead
  extends HttpRequestBase
{
  public HttpHead() {}
  
  public HttpHead(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public HttpHead(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "HEAD";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/HttpHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */