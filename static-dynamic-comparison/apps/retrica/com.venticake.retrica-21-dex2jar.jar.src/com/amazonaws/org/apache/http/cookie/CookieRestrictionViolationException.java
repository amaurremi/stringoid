package com.amazonaws.org.apache.http.cookie;

import org.apache.http.annotation.Immutable;

@Immutable
public class CookieRestrictionViolationException
  extends MalformedCookieException
{
  public CookieRestrictionViolationException() {}
  
  public CookieRestrictionViolationException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/CookieRestrictionViolationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */