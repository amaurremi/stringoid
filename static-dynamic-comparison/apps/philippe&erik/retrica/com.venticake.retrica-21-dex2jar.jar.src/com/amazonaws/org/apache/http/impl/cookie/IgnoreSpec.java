package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import java.util.Collections;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class IgnoreSpec
  extends CookieSpecBase
{
  public List<Header> formatCookies(List<Cookie> paramList)
  {
    return Collections.emptyList();
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public Header getVersionHeader()
  {
    return null;
  }
  
  public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin)
  {
    return Collections.emptyList();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/IgnoreSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */