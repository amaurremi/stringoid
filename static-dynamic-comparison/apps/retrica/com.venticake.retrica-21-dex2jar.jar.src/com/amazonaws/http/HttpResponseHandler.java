package com.amazonaws.http;

public abstract interface HttpResponseHandler<T>
{
  public abstract T handle(HttpResponse paramHttpResponse);
  
  public abstract boolean needsConnectionLeftOpen();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */