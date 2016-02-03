package com.amazonaws.org.apache.http.impl.entity;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.annotation.Immutable;

@Immutable
public class StrictContentLengthStrategy
  implements ContentLengthStrategy
{
  private final int implicitLen;
  
  public StrictContentLengthStrategy()
  {
    this(-1);
  }
  
  public StrictContentLengthStrategy(int paramInt)
  {
    this.implicitLen = paramInt;
  }
  
  public long determineLength(HttpMessage paramHttpMessage)
  {
    if (paramHttpMessage == null) {
      throw new IllegalArgumentException("HTTP message may not be null");
    }
    Object localObject = paramHttpMessage.getFirstHeader("Transfer-Encoding");
    long l1;
    if (localObject != null)
    {
      localObject = ((Header)localObject).getValue();
      if ("chunked".equalsIgnoreCase((String)localObject))
      {
        if (paramHttpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
          throw new ProtocolException("Chunked transfer encoding not allowed for " + paramHttpMessage.getProtocolVersion());
        }
        l1 = -2L;
      }
    }
    for (;;)
    {
      return l1;
      if ("identity".equalsIgnoreCase((String)localObject)) {
        return -1L;
      }
      throw new ProtocolException("Unsupported transfer encoding: " + (String)localObject);
      paramHttpMessage = paramHttpMessage.getFirstHeader("Content-Length");
      if (paramHttpMessage != null)
      {
        paramHttpMessage = paramHttpMessage.getValue();
        try
        {
          long l2 = Long.parseLong(paramHttpMessage);
          l1 = l2;
          if (l2 < 0L) {
            throw new ProtocolException("Negative content length: " + paramHttpMessage);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new ProtocolException("Invalid content length: " + paramHttpMessage);
        }
      }
    }
    return this.implicitLen;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/entity/StrictContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */