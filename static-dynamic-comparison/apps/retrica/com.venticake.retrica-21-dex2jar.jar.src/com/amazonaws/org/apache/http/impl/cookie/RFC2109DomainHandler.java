package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieAttributeHandler;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public class RFC2109DomainHandler
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
    paramCookieOrigin = paramCookieOrigin.getHost();
    paramCookie = paramCookie.getDomain();
    if (paramCookie == null) {}
    while ((!paramCookieOrigin.equals(paramCookie)) && ((!paramCookie.startsWith(".")) || (!paramCookieOrigin.endsWith(paramCookie)))) {
      return false;
    }
    return true;
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
    paramCookieOrigin = paramCookieOrigin.getHost();
    paramCookie = paramCookie.getDomain();
    if (paramCookie == null) {
      throw new CookieRestrictionViolationException("Cookie domain may not be null");
    }
    if (!paramCookie.equals(paramCookieOrigin))
    {
      if (paramCookie.indexOf('.') == -1) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie + "\" does not match the host \"" + paramCookieOrigin + "\"");
      }
      if (!paramCookie.startsWith(".")) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie + "\" violates RFC 2109: domain must start with a dot");
      }
      int i = paramCookie.indexOf('.', 1);
      if ((i < 0) || (i == paramCookie.length() - 1)) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie + "\" violates RFC 2109: domain must contain an embedded dot");
      }
      paramCookieOrigin = paramCookieOrigin.toLowerCase(Locale.ENGLISH);
      if (!paramCookieOrigin.endsWith(paramCookie)) {
        throw new CookieRestrictionViolationException("Illegal domain attribute \"" + paramCookie + "\". Domain of origin: \"" + paramCookieOrigin + "\"");
      }
      if (paramCookieOrigin.substring(0, paramCookieOrigin.length() - paramCookie.length()).indexOf('.') != -1) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie + "\" violates RFC 2109: host minus domain may not contain any dots");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/RFC2109DomainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */