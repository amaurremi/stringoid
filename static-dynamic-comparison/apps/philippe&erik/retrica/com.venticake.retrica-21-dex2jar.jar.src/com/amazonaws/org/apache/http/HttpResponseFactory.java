package com.amazonaws.org.apache.http;

import com.amazonaws.org.apache.http.protocol.HttpContext;

public abstract interface HttpResponseFactory
{
  public abstract HttpResponse newHttpResponse(StatusLine paramStatusLine, HttpContext paramHttpContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HttpResponseFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */