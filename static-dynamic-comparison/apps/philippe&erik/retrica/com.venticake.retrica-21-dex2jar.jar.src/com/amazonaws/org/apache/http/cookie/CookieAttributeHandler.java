package com.amazonaws.org.apache.http.cookie;

public abstract interface CookieAttributeHandler
{
  public abstract boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  public abstract void parse(SetCookie paramSetCookie, String paramString);
  
  public abstract void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/CookieAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */