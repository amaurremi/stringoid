package com.amazonaws.org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class InputStreamEntity
  extends AbstractHttpEntity
{
  private final InputStream content;
  private final long length;
  
  public InputStreamEntity(InputStream paramInputStream, long paramLong)
  {
    this(paramInputStream, paramLong, null);
  }
  
  public InputStreamEntity(InputStream paramInputStream, long paramLong, ContentType paramContentType)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Source input stream may not be null");
    }
    this.content = paramInputStream;
    this.length = paramLong;
    if (paramContentType != null) {
      setContentType(paramContentType.toString());
    }
  }
  
  public InputStream getContent()
  {
    return this.content;
  }
  
  public long getContentLength()
  {
    return this.length;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    InputStream localInputStream = this.content;
    byte[] arrayOfByte;
    int i;
    try
    {
      arrayOfByte = new byte['ࠀ'];
      if (this.length < 0L) {
        for (;;)
        {
          i = localInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
      }
      l = this.length;
    }
    finally
    {
      localInputStream.close();
    }
    for (;;)
    {
      long l;
      if (l > 0L)
      {
        i = localInputStream.read(arrayOfByte, 0, (int)Math.min(2048L, l));
        if (i != -1) {}
      }
      else
      {
        localInputStream.close();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l -= i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/InputStreamEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */