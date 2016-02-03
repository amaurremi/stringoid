package com.amazonaws.org.apache.http.client.methods;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.client.utils.CloneUtils;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class HttpEntityEnclosingRequestBase
  extends HttpRequestBase
  implements HttpEntityEnclosingRequest
{
  private HttpEntity entity;
  
  public Object clone()
  {
    HttpEntityEnclosingRequestBase localHttpEntityEnclosingRequestBase = (HttpEntityEnclosingRequestBase)super.clone();
    if (this.entity != null) {
      localHttpEntityEnclosingRequestBase.entity = ((HttpEntity)CloneUtils.clone(this.entity));
    }
    return localHttpEntityEnclosingRequestBase;
  }
  
  public boolean expectContinue()
  {
    Header localHeader = getFirstHeader("Expect");
    return (localHeader != null) && ("100-continue".equalsIgnoreCase(localHeader.getValue()));
  }
  
  public HttpEntity getEntity()
  {
    return this.entity;
  }
  
  public void setEntity(HttpEntity paramHttpEntity)
  {
    this.entity = paramHttpEntity;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/HttpEntityEnclosingRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */