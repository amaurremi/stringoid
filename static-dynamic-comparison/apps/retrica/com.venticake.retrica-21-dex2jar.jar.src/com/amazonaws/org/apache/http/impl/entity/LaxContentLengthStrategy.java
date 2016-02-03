package com.amazonaws.org.apache.http.impl.entity;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.HttpMessage;
import com.amazonaws.org.apache.http.ParseException;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.entity.ContentLengthStrategy;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class LaxContentLengthStrategy
  implements ContentLengthStrategy
{
  private final int implicitLen;
  
  public LaxContentLengthStrategy()
  {
    this(-1);
  }
  
  public LaxContentLengthStrategy(int paramInt)
  {
    this.implicitLen = paramInt;
  }
  
  public long determineLength(HttpMessage paramHttpMessage)
  {
    if (paramHttpMessage == null) {
      throw new IllegalArgumentException("HTTP message may not be null");
    }
    boolean bool = paramHttpMessage.getParams().isParameterTrue("http.protocol.strict-transfer-encoding");
    Header localHeader = paramHttpMessage.getFirstHeader("Transfer-Encoding");
    int i;
    long l2;
    if (localHeader != null)
    {
      for (;;)
      {
        try
        {
          paramHttpMessage = localHeader.getElements();
          if (!bool) {
            break;
          }
          i = 0;
          if (i >= paramHttpMessage.length) {
            break;
          }
          String str = paramHttpMessage[i].getName();
          if ((str != null) && (str.length() > 0) && (!str.equalsIgnoreCase("chunked")) && (!str.equalsIgnoreCase("identity"))) {
            throw new ProtocolException("Unsupported transfer encoding: " + str);
          }
        }
        catch (ParseException paramHttpMessage)
        {
          throw new ProtocolException("Invalid Transfer-Encoding header value: " + localHeader, paramHttpMessage);
        }
        i += 1;
      }
      i = paramHttpMessage.length;
      if ("identity".equalsIgnoreCase(localHeader.getValue()))
      {
        l2 = -1L;
        return l2;
      }
      if ((i > 0) && ("chunked".equalsIgnoreCase(paramHttpMessage[(i - 1)].getName()))) {
        return -2L;
      }
      if (bool) {
        throw new ProtocolException("Chunk-encoding must be the last one applied");
      }
      return -1L;
    }
    if (paramHttpMessage.getFirstHeader("Content-Length") != null)
    {
      paramHttpMessage = paramHttpMessage.getHeaders("Content-Length");
      if ((bool) && (paramHttpMessage.length > 1)) {
        throw new ProtocolException("Multiple content length headers");
      }
      i = paramHttpMessage.length - 1;
      label286:
      if (i < 0) {
        break label374;
      }
      localHeader = paramHttpMessage[i];
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(localHeader.getValue());
        l2 = l1;
        if (l1 >= 0L) {
          break;
        }
        return -1L;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (bool) {
          throw new ProtocolException("Invalid content length: " + localHeader.getValue());
        }
        i -= 1;
      }
      break label286;
      return this.implicitLen;
      label374:
      long l1 = -1L;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/entity/LaxContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */