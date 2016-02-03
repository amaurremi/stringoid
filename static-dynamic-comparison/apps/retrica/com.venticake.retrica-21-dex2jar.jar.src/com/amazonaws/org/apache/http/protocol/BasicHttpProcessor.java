package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseInterceptor;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public final class BasicHttpProcessor
  implements HttpProcessor, Cloneable
{
  protected final List<HttpRequestInterceptor> requestInterceptors = new ArrayList();
  protected final List<HttpResponseInterceptor> responseInterceptors = new ArrayList();
  
  public final void addInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor)
  {
    addRequestInterceptor(paramHttpRequestInterceptor);
  }
  
  public final void addInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt)
  {
    addRequestInterceptor(paramHttpRequestInterceptor, paramInt);
  }
  
  public final void addInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    addResponseInterceptor(paramHttpResponseInterceptor);
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor)
  {
    if (paramHttpRequestInterceptor == null) {
      return;
    }
    this.requestInterceptors.add(paramHttpRequestInterceptor);
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt)
  {
    if (paramHttpRequestInterceptor == null) {
      return;
    }
    this.requestInterceptors.add(paramInt, paramHttpRequestInterceptor);
  }
  
  public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    if (paramHttpResponseInterceptor == null) {
      return;
    }
    this.responseInterceptors.add(paramHttpResponseInterceptor);
  }
  
  public Object clone()
  {
    BasicHttpProcessor localBasicHttpProcessor = (BasicHttpProcessor)super.clone();
    copyInterceptors(localBasicHttpProcessor);
    return localBasicHttpProcessor;
  }
  
  protected void copyInterceptors(BasicHttpProcessor paramBasicHttpProcessor)
  {
    paramBasicHttpProcessor.requestInterceptors.clear();
    paramBasicHttpProcessor.requestInterceptors.addAll(this.requestInterceptors);
    paramBasicHttpProcessor.responseInterceptors.clear();
    paramBasicHttpProcessor.responseInterceptors.addAll(this.responseInterceptors);
  }
  
  public HttpRequestInterceptor getRequestInterceptor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.requestInterceptors.size())) {
      return null;
    }
    return (HttpRequestInterceptor)this.requestInterceptors.get(paramInt);
  }
  
  public int getRequestInterceptorCount()
  {
    return this.requestInterceptors.size();
  }
  
  public HttpResponseInterceptor getResponseInterceptor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.responseInterceptors.size())) {
      return null;
    }
    return (HttpResponseInterceptor)this.responseInterceptors.get(paramInt);
  }
  
  public int getResponseInterceptorCount()
  {
    return this.responseInterceptors.size();
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    int i = 0;
    while (i < this.requestInterceptors.size())
    {
      ((HttpRequestInterceptor)this.requestInterceptors.get(i)).process(paramHttpRequest, paramHttpContext);
      i += 1;
    }
  }
  
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    int i = 0;
    while (i < this.responseInterceptors.size())
    {
      ((HttpResponseInterceptor)this.responseInterceptors.get(i)).process(paramHttpResponse, paramHttpContext);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/BasicHttpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */