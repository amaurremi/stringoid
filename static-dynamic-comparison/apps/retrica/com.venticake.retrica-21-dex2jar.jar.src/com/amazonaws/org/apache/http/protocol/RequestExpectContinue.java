package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestExpectContinue
  implements HttpRequestInterceptor
{
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      paramHttpContext = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
      if ((paramHttpContext != null) && (paramHttpContext.getContentLength() != 0L))
      {
        paramHttpContext = paramHttpRequest.getRequestLine().getProtocolVersion();
        if ((HttpProtocolParams.useExpectContinue(paramHttpRequest.getParams())) && (!paramHttpContext.lessEquals(HttpVersion.HTTP_1_0))) {
          paramHttpRequest.addHeader("Expect", "100-continue");
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/RequestExpectContinue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */