package com.amazonaws.org.apache.http.client.methods;

import com.amazonaws.org.apache.http.HttpRequest;
import java.net.URI;

public abstract interface HttpUriRequest
  extends HttpRequest
{
  public abstract String getMethod();
  
  public abstract URI getURI();
  
  public abstract boolean isAborted();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/HttpUriRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */