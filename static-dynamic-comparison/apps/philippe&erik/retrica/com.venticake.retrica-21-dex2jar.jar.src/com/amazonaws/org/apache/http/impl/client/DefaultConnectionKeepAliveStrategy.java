package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.HeaderElementIterator;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazonaws.org.apache.http.message.BasicHeaderElementIterator;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import org.apache.http.annotation.Immutable;

@Immutable
public class DefaultConnectionKeepAliveStrategy
  implements ConnectionKeepAliveStrategy
{
  public long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    paramHttpResponse = new BasicHeaderElementIterator(paramHttpResponse.headerIterator("Keep-Alive"));
    for (;;)
    {
      Object localObject;
      if (paramHttpResponse.hasNext())
      {
        localObject = paramHttpResponse.nextElement();
        paramHttpContext = ((HeaderElement)localObject).getName();
        localObject = ((HeaderElement)localObject).getValue();
        if ((localObject == null) || (!paramHttpContext.equalsIgnoreCase("timeout"))) {}
      }
      else
      {
        try
        {
          long l = Long.parseLong((String)localObject);
          return l * 1000L;
        }
        catch (NumberFormatException paramHttpContext) {}
        return -1L;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultConnectionKeepAliveStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */