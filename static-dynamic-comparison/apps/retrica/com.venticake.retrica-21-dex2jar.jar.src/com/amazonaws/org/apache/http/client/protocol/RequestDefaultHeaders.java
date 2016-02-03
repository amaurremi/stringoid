package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.Collection;
import java.util.Iterator;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestDefaultHeaders
  implements HttpRequestInterceptor
{
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {}
    for (;;)
    {
      return;
      paramHttpContext = (Collection)paramHttpRequest.getParams().getParameter("http.default-headers");
      if (paramHttpContext != null)
      {
        paramHttpContext = paramHttpContext.iterator();
        while (paramHttpContext.hasNext()) {
          paramHttpRequest.addHeader((Header)paramHttpContext.next());
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestDefaultHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */