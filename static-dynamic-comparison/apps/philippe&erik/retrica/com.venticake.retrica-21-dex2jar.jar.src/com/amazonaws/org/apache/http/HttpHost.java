package com.amazonaws.org.apache.http;

import com.amazonaws.org.apache.http.util.LangUtils;
import java.io.Serializable;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public final class HttpHost
  implements Serializable, Cloneable
{
  protected final String hostname;
  protected final String lcHostname;
  protected final int port;
  protected final String schemeName;
  
  public HttpHost(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public HttpHost(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Host name may not be null");
    }
    this.hostname = paramString1;
    this.lcHostname = paramString1.toLowerCase(Locale.ENGLISH);
    if (paramString2 != null) {}
    for (this.schemeName = paramString2.toLowerCase(Locale.ENGLISH);; this.schemeName = "http")
    {
      this.port = paramInt;
      return;
    }
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HttpHost)) {
        break;
      }
      paramObject = (HttpHost)paramObject;
    } while ((this.lcHostname.equals(((HttpHost)paramObject).lcHostname)) && (this.port == ((HttpHost)paramObject).port) && (this.schemeName.equals(((HttpHost)paramObject).schemeName)));
    return false;
    return false;
  }
  
  public String getHostName()
  {
    return this.hostname;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public String getSchemeName()
  {
    return this.schemeName;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
  }
  
  public String toHostString()
  {
    if (this.port != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.hostname.length() + 6);
      localStringBuilder.append(this.hostname);
      localStringBuilder.append(":");
      localStringBuilder.append(Integer.toString(this.port));
      return localStringBuilder.toString();
    }
    return this.hostname;
  }
  
  public String toString()
  {
    return toURI();
  }
  
  public String toURI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.schemeName);
    localStringBuilder.append("://");
    localStringBuilder.append(this.hostname);
    if (this.port != -1)
    {
      localStringBuilder.append(':');
      localStringBuilder.append(Integer.toString(this.port));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HttpHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */