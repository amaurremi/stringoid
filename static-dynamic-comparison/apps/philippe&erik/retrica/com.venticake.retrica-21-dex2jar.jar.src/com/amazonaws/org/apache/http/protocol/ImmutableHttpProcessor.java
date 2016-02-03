package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class ImmutableHttpProcessor
  implements HttpProcessor
{
  private final HttpRequestInterceptor[] requestInterceptors;
  private final HttpResponseInterceptor[] responseInterceptors;
  
  public ImmutableHttpProcessor(HttpRequestInterceptor[] paramArrayOfHttpRequestInterceptor, HttpResponseInterceptor[] paramArrayOfHttpResponseInterceptor)
  {
    int k;
    int i;
    if (paramArrayOfHttpRequestInterceptor != null)
    {
      k = paramArrayOfHttpRequestInterceptor.length;
      this.requestInterceptors = new HttpRequestInterceptor[k];
      i = 0;
      while (i < k)
      {
        this.requestInterceptors[i] = paramArrayOfHttpRequestInterceptor[i];
        i += 1;
      }
    }
    this.requestInterceptors = new HttpRequestInterceptor[0];
    if (paramArrayOfHttpResponseInterceptor != null)
    {
      k = paramArrayOfHttpResponseInterceptor.length;
      this.responseInterceptors = new HttpResponseInterceptor[k];
      i = j;
      while (i < k)
      {
        this.responseInterceptors[i] = paramArrayOfHttpResponseInterceptor[i];
        i += 1;
      }
    }
    this.responseInterceptors = new HttpResponseInterceptor[0];
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    int i = 0;
    while (i < this.requestInterceptors.length)
    {
      this.requestInterceptors[i].process(paramHttpRequest, paramHttpContext);
      i += 1;
    }
  }
  
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    int i = 0;
    while (i < this.responseInterceptors.length)
    {
      this.responseInterceptors[i].process(paramHttpResponse, paramHttpContext);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/ImmutableHttpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */