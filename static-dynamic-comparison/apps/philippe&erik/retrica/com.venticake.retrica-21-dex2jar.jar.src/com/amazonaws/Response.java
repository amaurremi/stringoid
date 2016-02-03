package com.amazonaws;

import com.amazonaws.http.HttpResponse;

public final class Response<T>
{
  private final HttpResponse httpResponse;
  private final T response;
  
  public Response(T paramT, HttpResponse paramHttpResponse)
  {
    this.response = paramT;
    this.httpResponse = paramHttpResponse;
  }
  
  public T getAwsResponse()
  {
    return (T)this.response;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */