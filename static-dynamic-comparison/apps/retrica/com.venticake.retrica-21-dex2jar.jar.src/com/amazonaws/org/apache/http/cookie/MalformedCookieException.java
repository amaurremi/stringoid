package com.amazonaws.org.apache.http.cookie;

import com.amazonaws.org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;

@Immutable
public class MalformedCookieException
  extends ProtocolException
{
  public MalformedCookieException() {}
  
  public MalformedCookieException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/MalformedCookieException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */