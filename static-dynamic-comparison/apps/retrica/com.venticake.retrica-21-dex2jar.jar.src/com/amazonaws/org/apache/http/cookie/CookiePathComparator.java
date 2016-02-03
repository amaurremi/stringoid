package com.amazonaws.org.apache.http.cookie;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.http.annotation.Immutable;

@Immutable
public class CookiePathComparator
  implements Serializable, Comparator<Cookie>
{
  private String normalizePath(Cookie paramCookie)
  {
    Object localObject = paramCookie.getPath();
    paramCookie = (Cookie)localObject;
    if (localObject == null) {
      paramCookie = "/";
    }
    localObject = paramCookie;
    if (!paramCookie.endsWith("/")) {
      localObject = paramCookie + '/';
    }
    return (String)localObject;
  }
  
  public int compare(Cookie paramCookie1, Cookie paramCookie2)
  {
    paramCookie1 = normalizePath(paramCookie1);
    paramCookie2 = normalizePath(paramCookie2);
    if (paramCookie1.equals(paramCookie2)) {}
    do
    {
      return 0;
      if (paramCookie1.startsWith(paramCookie2)) {
        return -1;
      }
    } while (!paramCookie2.startsWith(paramCookie1));
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/CookiePathComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */