package com.amazonaws.org.apache.http.entity;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.util.EntityUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BufferedHttpEntity
  extends HttpEntityWrapper
{
  private final byte[] buffer;
  
  public BufferedHttpEntity(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
    if ((!paramHttpEntity.isRepeatable()) || (paramHttpEntity.getContentLength() < 0L))
    {
      this.buffer = EntityUtils.toByteArray(paramHttpEntity);
      return;
    }
    this.buffer = null;
  }
  
  public InputStream getContent()
  {
    if (this.buffer != null) {
      return new ByteArrayInputStream(this.buffer);
    }
    return this.wrappedEntity.getContent();
  }
  
  public long getContentLength()
  {
    if (this.buffer != null) {
      return this.buffer.length;
    }
    return this.wrappedEntity.getContentLength();
  }
  
  public boolean isChunked()
  {
    return (this.buffer == null) && (this.wrappedEntity.isChunked());
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return (this.buffer == null) && (this.wrappedEntity.isStreaming());
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    if (this.buffer != null)
    {
      paramOutputStream.write(this.buffer);
      return;
    }
    this.wrappedEntity.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/BufferedHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */