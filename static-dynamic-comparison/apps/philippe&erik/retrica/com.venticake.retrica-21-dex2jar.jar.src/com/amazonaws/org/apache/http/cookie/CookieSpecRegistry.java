package com.amazonaws.org.apache.http.cookie;

import com.amazonaws.org.apache.http.params.HttpParams;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class CookieSpecRegistry
{
  private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs = new ConcurrentHashMap();
  
  public CookieSpec getCookieSpec(String paramString, HttpParams paramHttpParams)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    CookieSpecFactory localCookieSpecFactory = (CookieSpecFactory)this.registeredSpecs.get(paramString.toLowerCase(Locale.ENGLISH));
    if (localCookieSpecFactory != null) {
      return localCookieSpecFactory.newInstance(paramHttpParams);
    }
    throw new IllegalStateException("Unsupported cookie spec: " + paramString);
  }
  
  public void register(String paramString, CookieSpecFactory paramCookieSpecFactory)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramCookieSpecFactory == null) {
      throw new IllegalArgumentException("Cookie spec factory may not be null");
    }
    this.registeredSpecs.put(paramString.toLowerCase(Locale.ENGLISH), paramCookieSpecFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/CookieSpecRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */