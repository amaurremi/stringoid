package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.protocol.HttpContext;

public abstract interface RequestDirector
{
  public abstract HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/RequestDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */