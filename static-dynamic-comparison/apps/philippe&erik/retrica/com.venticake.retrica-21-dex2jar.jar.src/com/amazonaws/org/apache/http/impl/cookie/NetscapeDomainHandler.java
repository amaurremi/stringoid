package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;

@Immutable
public class NetscapeDomainHandler
  extends BasicDomainHandler
{
  private static boolean isSpecialDomain(String paramString)
  {
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    return (paramString.endsWith(".COM")) || (paramString.endsWith(".EDU")) || (paramString.endsWith(".NET")) || (paramString.endsWith(".GOV")) || (paramString.endsWith(".MIL")) || (paramString.endsWith(".ORG")) || (paramString.endsWith(".INT"));
  }
  
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
    if (paramCookie == null) {
      return false;
    }
    return paramCookieOrigin.endsWith(paramCookie);
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    super.validate(paramCookie, paramCookieOrigin);
    paramCookieOrigin = paramCookieOrigin.getHost();
    paramCookie = paramCookie.getDomain();
    if (paramCookieOrigin.contains("."))
    {
      int i = new StringTokenizer(paramCookie, ".").countTokens();
      if (isSpecialDomain(paramCookie))
      {
        if (i < 2) {
          throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie + "\" violates the Netscape cookie specification for " + "special domains");
        }
      }
      else if (i < 3) {
        throw new CookieRestrictionViolationException("Domain attribute \"" + paramCookie + "\" violates the Netscape cookie specification");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/NetscapeDomainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */