package com.amazonaws.org.apache.http.entity;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpEntity;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class HttpEntityWrapper
  implements HttpEntity
{
  protected HttpEntity wrappedEntity;
  
  public HttpEntityWrapper(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity == null) {
      throw new IllegalArgumentException("wrapped entity must not be null");
    }
    this.wrappedEntity = paramHttpEntity;
  }
  
  public InputStream getContent()
  {
    return this.wrappedEntity.getContent();
  }
  
  public Header getContentEncoding()
  {
    return this.wrappedEntity.getContentEncoding();
  }
  
  public long getContentLength()
  {
    return this.wrappedEntity.getContentLength();
  }
  
  public Header getContentType()
  {
    return this.wrappedEntity.getContentType();
  }
  
  public boolean isChunked()
  {
    return this.wrappedEntity.isChunked();
  }
  
  public boolean isRepeatable()
  {
    return this.wrappedEntity.isRepeatable();
  }
  
  public boolean isStreaming()
  {
    return this.wrappedEntity.isStreaming();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.wrappedEntity.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/HttpEntityWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */