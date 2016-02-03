package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpConnection;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpInetConnection;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import java.net.InetAddress;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestTargetHost
  implements HttpRequestInterceptor
{
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    ProtocolVersion localProtocolVersion = paramHttpRequest.getRequestLine().getProtocolVersion();
    if ((paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) && (localProtocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while (paramHttpRequest.containsHeader("Host"));
      HttpHost localHttpHost = (HttpHost)paramHttpContext.getAttribute("http.target_host");
      localObject = localHttpHost;
      if (localHttpHost != null) {
        break;
      }
      localObject = (HttpConnection)paramHttpContext.getAttribute("http.connection");
      paramHttpContext = localHttpHost;
      if ((localObject instanceof HttpInetConnection))
      {
        InetAddress localInetAddress = ((HttpInetConnection)localObject).getRemoteAddress();
        int i = ((HttpInetConnection)localObject).getRemotePort();
        paramHttpContext = localHttpHost;
        if (localInetAddress != null) {
          paramHttpContext = new HttpHost(localInetAddress.getHostName(), i);
        }
      }
      localObject = paramHttpContext;
      if (paramHttpContext != null) {
        break;
      }
    } while (localProtocolVersion.lessEquals(HttpVersion.HTTP_1_0));
    throw new ProtocolException("Target host missing");
    paramHttpRequest.addHeader("Host", ((HttpHost)localObject).toHostString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/RequestTargetHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */