package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.ClientCookie;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieAttributeHandler;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import com.amazonaws.org.apache.http.cookie.SetCookie2;
import org.apache.http.annotation.Immutable;

@Immutable
public class RFC2965VersionAttributeHandler
  implements CookieAttributeHandler
{
  public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    return true;
  }
  
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramString == null) {
      throw new MalformedCookieException("Missing value for version attribute");
    }
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        throw new MalformedCookieException("Invalid cookie version.");
      }
    }
    catch (NumberFormatException paramString)
    {
      int i;
      for (;;)
      {
        i = -1;
      }
      paramSetCookie.setVersion(i);
    }
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (((paramCookie instanceof SetCookie2)) && ((paramCookie instanceof ClientCookie)) && (!((ClientCookie)paramCookie).containsAttribute("version"))) {
      throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/RFC2965VersionAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */