package com.amazonaws.org.apache.http.auth;

import com.amazonaws.org.apache.http.params.HttpParams;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class AuthSchemeRegistry
{
  private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes = new ConcurrentHashMap();
  
  public AuthScheme getAuthScheme(String paramString, HttpParams paramHttpParams)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    AuthSchemeFactory localAuthSchemeFactory = (AuthSchemeFactory)this.registeredSchemes.get(paramString.toLowerCase(Locale.ENGLISH));
    if (localAuthSchemeFactory != null) {
      return localAuthSchemeFactory.newInstance(paramHttpParams);
    }
    throw new IllegalStateException("Unsupported authentication scheme: " + paramString);
  }
  
  public void register(String paramString, AuthSchemeFactory paramAuthSchemeFactory)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramAuthSchemeFactory == null) {
      throw new IllegalArgumentException("Authentication scheme factory may not be null");
    }
    this.registeredSchemes.put(paramString.toLowerCase(Locale.ENGLISH), paramAuthSchemeFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/AuthSchemeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */