package com.amazonaws.http.impl.client;

import com.amazonaws.org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class HttpRequestNoRetryHandler
  extends DefaultHttpRequestRetryHandler
{
  public static final HttpRequestNoRetryHandler Singleton = new HttpRequestNoRetryHandler();
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/impl/client/HttpRequestNoRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */