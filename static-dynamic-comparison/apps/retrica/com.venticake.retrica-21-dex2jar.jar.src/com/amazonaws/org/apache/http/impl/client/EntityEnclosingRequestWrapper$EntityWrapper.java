package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.entity.HttpEntityWrapper;
import java.io.InputStream;
import java.io.OutputStream;

class EntityEnclosingRequestWrapper$EntityWrapper
  extends HttpEntityWrapper
{
  EntityEnclosingRequestWrapper$EntityWrapper(EntityEnclosingRequestWrapper paramEntityEnclosingRequestWrapper, HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }
  
  public InputStream getContent()
  {
    EntityEnclosingRequestWrapper.access$002(this.this$0, true);
    return super.getContent();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    EntityEnclosingRequestWrapper.access$002(this.this$0, true);
    super.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/EntityEnclosingRequestWrapper$EntityWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */