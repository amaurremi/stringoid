package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicExpiresHandler
  extends AbstractCookieAttributeHandler
{
  private final String[] datepatterns;
  
  public BasicExpiresHandler(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("Array of date patterns may not be null");
    }
    this.datepatterns = paramArrayOfString;
  }
  
  public void parse(SetCookie paramSetCookie, String paramString)
  {
    if (paramSetCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramString == null) {
      throw new MalformedCookieException("Missing value for expires attribute");
    }
    try
    {
      paramSetCookie.setExpiryDate(DateUtils.parseDate(paramString, this.datepatterns));
      return;
    }
    catch (DateParseException paramSetCookie)
    {
      throw new MalformedCookieException("Unable to parse expires attribute: " + paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BasicExpiresHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */