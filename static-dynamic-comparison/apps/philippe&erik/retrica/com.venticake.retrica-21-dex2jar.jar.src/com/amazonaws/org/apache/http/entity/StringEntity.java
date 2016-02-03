package com.amazonaws.org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class StringEntity
  extends AbstractHttpEntity
  implements Cloneable
{
  protected final byte[] content;
  
  public StringEntity(String paramString)
  {
    this(paramString, ContentType.DEFAULT_TEXT);
  }
  
  public StringEntity(String paramString, ContentType paramContentType)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Source string may not be null");
    }
    if (paramContentType != null) {}
    for (localCharset = paramContentType.getCharset();; localCharset = null) {
      try
      {
        this.content = paramString.getBytes(localCharset.name());
        if (paramContentType != null) {
          setContentType(paramContentType.toString());
        }
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new UnsupportedCharsetException(localCharset.name());
      }
    }
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public InputStream getContent()
  {
    return new ByteArrayInputStream(this.content);
  }
  
  public long getContentLength()
  {
    return this.content.length;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    paramOutputStream.write(this.content);
    paramOutputStream.flush();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/StringEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */