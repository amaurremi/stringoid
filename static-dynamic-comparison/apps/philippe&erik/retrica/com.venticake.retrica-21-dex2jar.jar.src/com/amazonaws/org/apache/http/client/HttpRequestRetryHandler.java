package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.io.IOException;

public abstract interface HttpRequestRetryHandler
{
  public abstract boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/HttpRequestRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */