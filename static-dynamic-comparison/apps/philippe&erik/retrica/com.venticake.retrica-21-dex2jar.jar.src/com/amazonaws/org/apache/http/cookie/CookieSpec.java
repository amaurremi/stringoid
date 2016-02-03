package com.amazonaws.org.apache.http.cookie;

import com.amazonaws.org.apache.http.Header;
import java.util.List;

public abstract interface CookieSpec
{
  public abstract List<Header> formatCookies(List<Cookie> paramList);
  
  public abstract int getVersion();
  
  public abstract Header getVersionHeader();
  
  public abstract boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  public abstract List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin);
  
  public abstract void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/CookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */