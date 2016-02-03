package com.amazonaws.org.apache.http.cookie;

import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public final class CookieOrigin
{
  private final String host;
  private final String path;
  private final int port;
  private final boolean secure;
  
  public CookieOrigin(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Host of origin may not be null");
    }
    if (paramString1.trim().length() == 0) {
      throw new IllegalArgumentException("Host of origin may not be blank");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Invalid port: " + paramInt);
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Path of origin may not be null.");
    }
    this.host = paramString1.toLowerCase(Locale.ENGLISH);
    this.port = paramInt;
    if (paramString2.trim().length() != 0) {}
    for (this.path = paramString2;; this.path = "/")
    {
      this.secure = paramBoolean;
      return;
    }
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public boolean isSecure()
  {
    return this.secure;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    if (this.secure) {
      localStringBuilder.append("(secure)");
    }
    localStringBuilder.append(this.host);
    localStringBuilder.append(':');
    localStringBuilder.append(Integer.toString(this.port));
    localStringBuilder.append(this.path);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/CookieOrigin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */