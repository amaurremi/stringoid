package com.amazonaws.org.apache.http.client.protocol;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderIterator;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseInterceptor;
import com.amazonaws.org.apache.http.client.CookieStore;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieSpec;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
public class ResponseProcessCookies
  implements HttpResponseInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  private void processCookies(HeaderIterator paramHeaderIterator, CookieSpec paramCookieSpec, CookieOrigin paramCookieOrigin, CookieStore paramCookieStore)
  {
    while (paramHeaderIterator.hasNext())
    {
      Header localHeader = paramHeaderIterator.nextHeader();
      try
      {
        Iterator localIterator = paramCookieSpec.parse(localHeader, paramCookieOrigin).iterator();
        while (localIterator.hasNext())
        {
          Cookie localCookie = (Cookie)localIterator.next();
          try
          {
            paramCookieSpec.validate(localCookie, paramCookieOrigin);
            paramCookieStore.addCookie(localCookie);
            if (!this.log.isDebugEnabled()) {
              continue;
            }
            this.log.debug("Cookie accepted: \"" + localCookie + "\". ");
          }
          catch (MalformedCookieException localMalformedCookieException2) {}
          if (this.log.isWarnEnabled()) {
            this.log.warn("Cookie rejected: \"" + localCookie + "\". " + localMalformedCookieException2.getMessage());
          }
        }
        if (!this.log.isWarnEnabled()) {
          continue;
        }
      }
      catch (MalformedCookieException localMalformedCookieException1) {}
      this.log.warn("Invalid cookie header: \"" + localHeader + "\". " + localMalformedCookieException1.getMessage());
    }
  }
  
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    CookieSpec localCookieSpec = (CookieSpec)paramHttpContext.getAttribute("http.cookie-spec");
    if (localCookieSpec == null) {
      this.log.debug("Cookie spec not specified in HTTP context");
    }
    CookieStore localCookieStore;
    do
    {
      return;
      localCookieStore = (CookieStore)paramHttpContext.getAttribute("http.cookie-store");
      if (localCookieStore == null)
      {
        this.log.debug("Cookie store not specified in HTTP context");
        return;
      }
      paramHttpContext = (CookieOrigin)paramHttpContext.getAttribute("http.cookie-origin");
      if (paramHttpContext == null)
      {
        this.log.debug("Cookie origin not specified in HTTP context");
        return;
      }
      processCookies(paramHttpResponse.headerIterator("Set-Cookie"), localCookieSpec, paramHttpContext, localCookieStore);
    } while (localCookieSpec.getVersion() <= 0);
    processCookies(paramHttpResponse.headerIterator("Set-Cookie2"), localCookieSpec, paramHttpContext, localCookieStore);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/protocol/ResponseProcessCookies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */