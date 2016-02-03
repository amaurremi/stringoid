package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpException;
import com.amazonaws.org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;

@Immutable
public class TunnelRefusedException
  extends HttpException
{
  private final HttpResponse response;
  
  public TunnelRefusedException(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString);
    this.response = paramHttpResponse;
  }
  
  public HttpResponse getResponse()
  {
    return this.response;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/TunnelRefusedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */