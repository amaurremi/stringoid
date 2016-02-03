package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class EntityEnclosingRequestWrapper
  extends RequestWrapper
  implements HttpEntityEnclosingRequest
{
  private boolean consumed;
  private HttpEntity entity;
  
  public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    super(paramHttpEntityEnclosingRequest);
    setEntity(paramHttpEntityEnclosingRequest.getEntity());
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
  
  public boolean isRepeatable()
  {
    return (this.entity == null) || (this.entity.isRepeatable()) || (!this.consumed);
  }
  
  public void setEntity(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null) {}
    for (paramHttpEntity = new EntityEnclosingRequestWrapper.EntityWrapper(this, paramHttpEntity);; paramHttpEntity = null)
    {
      this.entity = paramHttpEntity;
      this.consumed = false;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/EntityEnclosingRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */