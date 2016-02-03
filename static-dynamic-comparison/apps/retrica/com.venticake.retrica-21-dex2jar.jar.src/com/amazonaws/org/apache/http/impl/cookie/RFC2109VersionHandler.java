package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import org.apache.http.annotation.Immutable;

@Immutable
public class RFC2109VersionHandler
  extends AbstractCookieAttributeHandler
{
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramString == null) {
      throw new MalformedCookieException("Missing value for version attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new MalformedCookieException("Blank value for version attribute");
    }
    try
    {
      paramSetCookie.setVersion(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException paramSetCookie)
    {
      throw new MalformedCookieException("Invalid version: " + paramSetCookie.getMessage());
    }
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookie.getVersion() < 0) {
      throw new CookieRestrictionViolationException("Cookie version may not be negative");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/RFC2109VersionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */