package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieAttributeHandler;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicPathHandler
  implements CookieAttributeHandler
{
  public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    String str = paramCookieOrigin.getPath();
    paramCookieOrigin = paramCookie.getPath();
    paramCookie = paramCookieOrigin;
    if (paramCookieOrigin == null) {
      paramCookie = "/";
    }
    paramCookieOrigin = paramCookie;
    if (paramCookie.length() > 1)
    {
      paramCookieOrigin = paramCookie;
      if (paramCookie.endsWith("/")) {
        paramCookieOrigin = paramCookie.substring(0, paramCookie.length() - 1);
      }
    }
    boolean bool = str.startsWith(paramCookieOrigin);
    if ((bool) && (str.length() != paramCookieOrigin.length()) && (!paramCookieOrigin.endsWith("/"))) {
      return str.charAt(paramCookieOrigin.length()) == '/';
    }
    return bool;
  }
  
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.trim().length() != 0) {}
    }
    else
    {
      str = "/";
    }
    paramSetCookie.setPath(str);
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (!match(paramCookie, paramCookieOrigin)) {
      throw new CookieRestrictionViolationException("Illegal path attribute \"" + paramCookie.getPath() + "\". Path of origin: \"" + paramCookieOrigin.getPath() + "\"");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BasicPathHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */