package com.amazonaws.org.apache.http.client;

import com.amazonaws.org.apache.http.cookie.Cookie;
import java.util.List;

public abstract interface CookieStore
{
  public abstract void addCookie(Cookie paramCookie);
  
  public abstract List<Cookie> getCookies();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/CookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */