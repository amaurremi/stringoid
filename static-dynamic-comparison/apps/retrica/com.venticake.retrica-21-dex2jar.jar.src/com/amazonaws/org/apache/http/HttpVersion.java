package com.amazonaws.org.apache.http;

import java.io.Serializable;
import org.apache.http.annotation.Immutable;

@Immutable
public final class HttpVersion
  extends ProtocolVersion
  implements Serializable
{
  public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
  public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
  public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
  
  public HttpVersion(int paramInt1, int paramInt2)
  {
    super("HTTP", paramInt1, paramInt2);
  }
  
  public ProtocolVersion forVersion(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.major) && (paramInt2 == this.minor)) {
      return this;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0) {
        return HTTP_1_0;
      }
      if (paramInt2 == 1) {
        return HTTP_1_1;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 9)) {
      return HTTP_0_9;
    }
    return new HttpVersion(paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HttpVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */