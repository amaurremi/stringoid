package com.amazonaws.org.apache.http.impl.entity;

import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.entity.ContentLengthStrategy;
import com.amazonaws.org.apache.http.impl.io.ChunkedOutputStream;
import com.amazonaws.org.apache.http.impl.io.ContentLengthOutputStream;
import com.amazonaws.org.apache.http.impl.io.IdentityOutputStream;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import java.io.OutputStream;
import org.apache.http.annotation.Immutable;

@Immutable
public class EntitySerializer
{
  private final ContentLengthStrategy lenStrategy;
  
  public EntitySerializer(ContentLengthStrategy paramContentLengthStrategy)
  {
    if (paramContentLengthStrategy == null) {
      throw new IllegalArgumentException("Content length strategy may not be null");
    }
    this.lenStrategy = paramContentLengthStrategy;
  }
  
  protected OutputStream doSerialize(SessionOutputBuffer paramSessionOutputBuffer, HttpMessage paramHttpMessage)
  {
    long l = this.lenStrategy.determineLength(paramHttpMessage);
    if (l == -2L) {
      return new ChunkedOutputStream(paramSessionOutputBuffer);
    }
    if (l == -1L) {
      return new IdentityOutputStream(paramSessionOutputBuffer);
    }
    return new ContentLengthOutputStream(paramSessionOutputBuffer, l);
  }
  
  public void serialize(SessionOutputBuffer paramSessionOutputBuffer, HttpMessage paramHttpMessage, HttpEntity paramHttpEntity)
  {
    if (paramSessionOutputBuffer == null) {
      throw new IllegalArgumentException("Session output buffer may not be null");
    }
    if (paramHttpMessage == null) {
      throw new IllegalArgumentException("HTTP message may not be null");
    }
    if (paramHttpEntity == null) {
      throw new IllegalArgumentException("HTTP entity may not be null");
    }
    paramSessionOutputBuffer = doSerialize(paramSessionOutputBuffer, paramHttpMessage);
    paramHttpEntity.writeTo(paramSessionOutputBuffer);
    paramSessionOutputBuffer.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/entity/EntitySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */