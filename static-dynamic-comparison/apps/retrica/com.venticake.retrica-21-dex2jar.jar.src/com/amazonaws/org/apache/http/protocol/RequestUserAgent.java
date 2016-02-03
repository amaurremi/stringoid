package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestUserAgent
  implements HttpRequestInterceptor
{
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (!paramHttpRequest.containsHeader("User-Agent"))
    {
      paramHttpContext = HttpProtocolParams.getUserAgent(paramHttpRequest.getParams());
      if (paramHttpContext != null) {
        paramHttpRequest.addHeader("User-Agent", paramHttpContext);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/RequestUserAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */