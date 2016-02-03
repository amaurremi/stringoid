package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestContent
  implements HttpRequestInterceptor
{
  private final boolean overwrite;
  
  public RequestContent()
  {
    this(false);
  }
  
  public RequestContent(boolean paramBoolean)
  {
    this.overwrite = paramBoolean;
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      if (!this.overwrite) {
        break label81;
      }
      paramHttpRequest.removeHeaders("Transfer-Encoding");
      paramHttpRequest.removeHeaders("Content-Length");
    }
    HttpEntity localHttpEntity;
    label81:
    do
    {
      paramHttpContext = paramHttpRequest.getRequestLine().getProtocolVersion();
      localHttpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
      if (localHttpEntity != null) {
        break;
      }
      paramHttpRequest.addHeader("Content-Length", "0");
      return;
      if (paramHttpRequest.containsHeader("Transfer-Encoding")) {
        throw new ProtocolException("Transfer-encoding header already present");
      }
    } while (!paramHttpRequest.containsHeader("Content-Length"));
    throw new ProtocolException("Content-Length header already present");
    if ((localHttpEntity.isChunked()) || (localHttpEntity.getContentLength() < 0L))
    {
      if (paramHttpContext.lessEquals(HttpVersion.HTTP_1_0)) {
        throw new ProtocolException("Chunked transfer encoding not allowed for " + paramHttpContext);
      }
      paramHttpRequest.addHeader("Transfer-Encoding", "chunked");
    }
    for (;;)
    {
      if ((localHttpEntity.getContentType() != null) && (!paramHttpRequest.containsHeader("Content-Type"))) {
        paramHttpRequest.addHeader(localHttpEntity.getContentType());
      }
      if ((localHttpEntity.getContentEncoding() == null) || (paramHttpRequest.containsHeader("Content-Encoding"))) {
        break;
      }
      paramHttpRequest.addHeader(localHttpEntity.getContentEncoding());
      return;
      paramHttpRequest.addHeader("Content-Length", Long.toString(localHttpEntity.getContentLength()));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/RequestContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */