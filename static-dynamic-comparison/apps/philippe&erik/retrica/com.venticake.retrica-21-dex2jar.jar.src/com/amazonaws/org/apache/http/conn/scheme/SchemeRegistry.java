package com.amazonaws.org.apache.http.conn.scheme;

import com.amazonaws.org.apache.http.HttpHost;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class SchemeRegistry
{
  private final ConcurrentHashMap<String, Scheme> registeredSchemes = new ConcurrentHashMap();
  
  public final Scheme get(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name must not be null.");
    }
    return (Scheme)this.registeredSchemes.get(paramString);
  }
  
  public final Scheme getScheme(HttpHost paramHttpHost)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Host must not be null.");
    }
    return getScheme(paramHttpHost.getSchemeName());
  }
  
  public final Scheme getScheme(String paramString)
  {
    Scheme localScheme = get(paramString);
    if (localScheme == null) {
      throw new IllegalStateException("Scheme '" + paramString + "' not registered.");
    }
    return localScheme;
  }
  
  public final Scheme register(Scheme paramScheme)
  {
    if (paramScheme == null) {
      throw new IllegalArgumentException("Scheme must not be null.");
    }
    return (Scheme)this.registeredSchemes.put(paramScheme.getName(), paramScheme);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/scheme/SchemeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */