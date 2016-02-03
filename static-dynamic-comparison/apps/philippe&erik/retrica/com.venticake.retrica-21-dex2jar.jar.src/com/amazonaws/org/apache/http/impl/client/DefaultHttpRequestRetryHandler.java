package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.client.HttpRequestRetryHandler;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.annotation.Immutable;

@Immutable
public class DefaultHttpRequestRetryHandler
  implements HttpRequestRetryHandler
{
  private final boolean requestSentRetryEnabled;
  private final int retryCount;
  
  public DefaultHttpRequestRetryHandler()
  {
    this(3, false);
  }
  
  public DefaultHttpRequestRetryHandler(int paramInt, boolean paramBoolean)
  {
    this.retryCount = paramInt;
    this.requestSentRetryEnabled = paramBoolean;
  }
  
  protected boolean handleAsIdempotent(HttpRequest paramHttpRequest)
  {
    return !(paramHttpRequest instanceof HttpEntityEnclosingRequest);
  }
  
  protected boolean requestIsAborted(HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof RequestWrapper)) {
      paramHttpRequest = ((RequestWrapper)paramHttpRequest).getOriginal();
    }
    for (;;)
    {
      return ((paramHttpRequest instanceof HttpUriRequest)) && (((HttpUriRequest)paramHttpRequest).isAborted());
    }
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    if (paramIOException == null) {
      throw new IllegalArgumentException("Exception parameter may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    if (paramInt > this.retryCount) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return false;
    }
    if ((paramIOException instanceof ConnectException)) {
      return false;
    }
    if ((paramIOException instanceof SSLException)) {
      return false;
    }
    paramIOException = (HttpRequest)paramHttpContext.getAttribute("http.request");
    if (requestIsAborted(paramIOException)) {
      return false;
    }
    if (handleAsIdempotent(paramIOException)) {
      return true;
    }
    paramIOException = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    if ((paramIOException != null) && (paramIOException.booleanValue())) {}
    for (paramInt = 1; (paramInt == 0) || (this.requestSentRetryEnabled); paramInt = 0) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultHttpRequestRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */