package com.amazonaws.org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpPost
  extends HttpEntityEnclosingRequestBase
{
  public HttpPost() {}
  
  public HttpPost(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public HttpPost(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "POST";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/HttpPost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */