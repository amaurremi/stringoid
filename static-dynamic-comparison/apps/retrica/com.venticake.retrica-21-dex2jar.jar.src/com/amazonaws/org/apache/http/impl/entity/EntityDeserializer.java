package com.amazonaws.org.apache.http.impl.entity;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.entity.BasicHttpEntity;
import com.amazonaws.org.apache.http.entity.ContentLengthStrategy;
import com.amazonaws.org.apache.http.impl.io.ChunkedInputStream;
import com.amazonaws.org.apache.http.impl.io.ContentLengthInputStream;
import com.amazonaws.org.apache.http.impl.io.IdentityInputStream;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import org.apache.http.annotation.Immutable;

@Immutable
public class EntityDeserializer
{
  private final ContentLengthStrategy lenStrategy;
  
  public EntityDeserializer(ContentLengthStrategy paramContentLengthStrategy)
  {
    if (paramContentLengthStrategy == null) {
      throw new IllegalArgumentException("Content length strategy may not be null");
    }
    this.lenStrategy = paramContentLengthStrategy;
  }
  
  public HttpEntity deserialize(SessionInputBuffer paramSessionInputBuffer, HttpMessage paramHttpMessage)
  {
    if (paramSessionInputBuffer == null) {
      throw new IllegalArgumentException("Session input buffer may not be null");
    }
    if (paramHttpMessage == null) {
      throw new IllegalArgumentException("HTTP message may not be null");
    }
    return doDeserialize(paramSessionInputBuffer, paramHttpMessage);
  }
  
  protected BasicHttpEntity doDeserialize(SessionInputBuffer paramSessionInputBuffer, HttpMessage paramHttpMessage)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    long l = this.lenStrategy.determineLength(paramHttpMessage);
    if (l == -2L)
    {
      localBasicHttpEntity.setChunked(true);
      localBasicHttpEntity.setContentLength(-1L);
      localBasicHttpEntity.setContent(new ChunkedInputStream(paramSessionInputBuffer));
    }
    for (;;)
    {
      paramSessionInputBuffer = paramHttpMessage.getFirstHeader("Content-Type");
      if (paramSessionInputBuffer != null) {
        localBasicHttpEntity.setContentType(paramSessionInputBuffer);
      }
      paramSessionInputBuffer = paramHttpMessage.getFirstHeader("Content-Encoding");
      if (paramSessionInputBuffer != null) {
        localBasicHttpEntity.setContentEncoding(paramSessionInputBuffer);
      }
      return localBasicHttpEntity;
      if (l == -1L)
      {
        localBasicHttpEntity.setChunked(false);
        localBasicHttpEntity.setContentLength(-1L);
        localBasicHttpEntity.setContent(new IdentityInputStream(paramSessionInputBuffer));
      }
      else
      {
        localBasicHttpEntity.setChunked(false);
        localBasicHttpEntity.setContentLength(l);
        localBasicHttpEntity.setContent(new ContentLengthInputStream(paramSessionInputBuffer, l));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/entity/EntityDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */