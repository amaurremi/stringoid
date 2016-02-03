package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieAttributeHandler;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicDomainHandler
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
    String str = paramCookieOrigin.getHost();
    paramCookieOrigin = paramCookie.getDomain();
    if (paramCookieOrigin == null) {
      return false;
    }
    if (str.equals(paramCookieOrigin)) {
      return true;
    }
    paramCookie = paramCookieOrigin;
    if (!paramCookieOrigin.startsWith(".")) {
      paramCookie = '.' + paramCookieOrigin;
    }
    if ((str.endsWith(paramCookie)) || (str.equals(paramCookie.substring(1)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramString == null) {
      throw new MalformedCookieException("Missing value for domain attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new MalformedCookieException("Blank value for domain attribute");
    }
    paramSetCookie.setDomain(paramString);
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    String str = paramCookieOrigin.getHost();
    paramCookieOrigin = paramCookie.getDomain();
    if (paramCookieOrigin == null) {
      throw new CookieRestrictionViolationException("Cookie domain may not be null");
    }
    if (str.contains("."))
    {
      if (!str.endsWith(paramCookieOrigin))
      {
        paramCookie = paramCookieOrigin;
        if (paramCookieOrigin.startsWith(".")) {
          paramCookie = paramCookieOrigin.substring(1, paramCookieOrigin.length());
        }
        if (!str.equals(paramCookie)) {
          throw new CookieRestrictionViolationException("Illegal domain attribute \"" + paramCookie + "\". Domain of origin: \"" + str + "\"");
        }
      }
    }
    else if (!str.equals(paramCookieOrigin)) {
      throw new CookieRestrictionViolationException("Illegal domain attribute \"" + paramCookieOrigin + "\". Domain of origin: \"" + str + "\"");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BasicDomainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */