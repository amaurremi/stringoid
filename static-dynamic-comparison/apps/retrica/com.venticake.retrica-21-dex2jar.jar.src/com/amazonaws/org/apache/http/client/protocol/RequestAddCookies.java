package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.client.CookieStore;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.client.params.HttpClientParams;
import com.amazonaws.org.apache.http.conn.HttpRoutedConnection;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieSpec;
import com.amazonaws.org.apache.http.cookie.CookieSpecRegistry;
import com.amazonaws.org.apache.http.cookie.SetCookie2;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestAddCookies
  implements HttpRequestInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    int j = 0;
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    if (paramHttpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
      return;
    }
    Object localObject2 = (CookieStore)paramHttpContext.getAttribute("http.cookie-store");
    if (localObject2 == null)
    {
      this.log.debug("Cookie store not specified in HTTP context");
      return;
    }
    Object localObject3 = (CookieSpecRegistry)paramHttpContext.getAttribute("http.cookiespec-registry");
    if (localObject3 == null)
    {
      this.log.debug("CookieSpec registry not specified in HTTP context");
      return;
    }
    Object localObject6 = (HttpHost)paramHttpContext.getAttribute("http.target_host");
    if (localObject6 == null)
    {
      this.log.debug("Target host not set in the context");
      return;
    }
    Object localObject5 = (HttpRoutedConnection)paramHttpContext.getAttribute("http.connection");
    if (localObject5 == null)
    {
      this.log.debug("HTTP connection not set in the context");
      return;
    }
    Object localObject4 = HttpClientParams.getCookiePolicy(paramHttpRequest.getParams());
    if (this.log.isDebugEnabled()) {
      this.log.debug("CookieSpec selected: " + (String)localObject4);
    }
    Object localObject1;
    String str;
    int i;
    if ((paramHttpRequest instanceof HttpUriRequest))
    {
      localObject1 = ((HttpUriRequest)paramHttpRequest).getURI();
      str = ((HttpHost)localObject6).getHostName();
      i = ((HttpHost)localObject6).getPort();
      if (i >= 0) {
        break label807;
      }
      if (((HttpRoutedConnection)localObject5).getRoute().getHopCount() != 1) {
        break label536;
      }
      i = ((HttpRoutedConnection)localObject5).getRemotePort();
    }
    label280:
    label536:
    label630:
    label711:
    label807:
    for (;;)
    {
      localObject1 = new CookieOrigin(str, i, ((URI)localObject1).getPath(), ((HttpRoutedConnection)localObject5).isSecure());
      localObject3 = ((CookieSpecRegistry)localObject3).getCookieSpec((String)localObject4, paramHttpRequest.getParams());
      localObject5 = new ArrayList(((CookieStore)localObject2).getCookies());
      localObject2 = new ArrayList();
      localObject4 = new Date();
      localObject5 = ((List)localObject5).iterator();
      for (;;)
      {
        if (!((Iterator)localObject5).hasNext()) {
          break label630;
        }
        localObject6 = (Cookie)((Iterator)localObject5).next();
        if (!((Cookie)localObject6).isExpired((Date)localObject4))
        {
          if (!((CookieSpec)localObject3).match((Cookie)localObject6, (CookieOrigin)localObject1)) {
            continue;
          }
          if (this.log.isDebugEnabled()) {
            this.log.debug("Cookie " + localObject6 + " match " + localObject1);
          }
          ((List)localObject2).add(localObject6);
          continue;
          try
          {
            localObject1 = new URI(paramHttpRequest.getRequestLine().getUri());
          }
          catch (URISyntaxException paramHttpContext)
          {
            throw new ProtocolException("Invalid request URI: " + paramHttpRequest.getRequestLine().getUri(), paramHttpContext);
          }
          localObject6 = ((HttpHost)localObject6).getSchemeName();
          if (((String)localObject6).equalsIgnoreCase("http"))
          {
            i = 80;
            break label280;
          }
          if (((String)localObject6).equalsIgnoreCase("https"))
          {
            i = 443;
            break label280;
          }
          i = 0;
          break label280;
        }
        if (this.log.isDebugEnabled()) {
          this.log.debug("Cookie " + localObject6 + " expired");
        }
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject4 = ((CookieSpec)localObject3).formatCookies((List)localObject2).iterator();
        while (((Iterator)localObject4).hasNext()) {
          paramHttpRequest.addHeader((Header)((Iterator)localObject4).next());
        }
      }
      int k = ((CookieSpec)localObject3).getVersion();
      if (k > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        for (i = j; ((Iterator)localObject2).hasNext(); i = 1)
        {
          localObject4 = (Cookie)((Iterator)localObject2).next();
          if ((k == ((Cookie)localObject4).getVersion()) && ((localObject4 instanceof SetCookie2))) {
            break label711;
          }
        }
        if (i != 0)
        {
          localObject2 = ((CookieSpec)localObject3).getVersionHeader();
          if (localObject2 != null) {
            paramHttpRequest.addHeader((Header)localObject2);
          }
        }
      }
      paramHttpContext.setAttribute("http.cookie-spec", localObject3);
      paramHttpContext.setAttribute("http.cookie-origin", localObject1);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/RequestAddCookies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */