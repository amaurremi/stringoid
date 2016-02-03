package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.conn.HttpRoutedConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestClientConnControl
  implements HttpRequestInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
      paramHttpRequest.setHeader("Proxy-Connection", "Keep-Alive");
    }
    do
    {
      return;
      paramHttpContext = (HttpRoutedConnection)paramHttpContext.getAttribute("http.connection");
      if (paramHttpContext == null)
      {
        this.log.debug("HTTP connection not set in the context");
        return;
      }
      paramHttpContext = paramHttpContext.getRoute();
      if (((paramHttpContext.getHopCount() == 1) || (paramHttpContext.isTunnelled())) && (!paramHttpRequest.containsHeader("Connection"))) {
        paramHttpRequest.addHeader("Connection", "Keep-Alive");
      }
    } while ((paramHttpContext.getHopCount() != 2) || (paramHttpContext.isTunnelled()) || (paramHttpRequest.containsHeader("Proxy-Connection")));
    paramHttpRequest.addHeader("Proxy-Connection", "Keep-Alive");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestClientConnControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */