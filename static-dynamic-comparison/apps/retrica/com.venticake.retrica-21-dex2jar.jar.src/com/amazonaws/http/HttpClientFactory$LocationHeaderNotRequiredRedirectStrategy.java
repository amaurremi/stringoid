package com.amazonaws.http;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.impl.client.DefaultRedirectStrategy;
import com.amazonaws.org.apache.http.protocol.HttpContext;

final class HttpClientFactory$LocationHeaderNotRequiredRedirectStrategy
  extends DefaultRedirectStrategy
{
  public boolean isRedirected(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if ((paramHttpResponse.getFirstHeader("location") == null) && (i == 301)) {
      return false;
    }
    return super.isRedirected(paramHttpRequest, paramHttpResponse, paramHttpContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpClientFactory$LocationHeaderNotRequiredRedirectStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */