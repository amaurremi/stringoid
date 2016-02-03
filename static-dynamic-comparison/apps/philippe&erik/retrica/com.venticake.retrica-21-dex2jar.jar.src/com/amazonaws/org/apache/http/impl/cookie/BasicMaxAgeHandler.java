package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import java.util.Date;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicMaxAgeHandler
  extends AbstractCookieAttributeHandler
{
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramString == null) {
      throw new MalformedCookieException("Missing value for max-age attribute");
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        throw new MalformedCookieException("Negative max-age attribute: " + paramString);
      }
    }
    catch (NumberFormatException paramSetCookie)
    {
      throw new MalformedCookieException("Invalid max-age attribute: " + paramString);
    }
    paramSetCookie.setExpiryDate(new Date(System.currentTimeMillis() + i * 1000L));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BasicMaxAgeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */