package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.ClientCookie;
import com.amazonaws.org.apache.http.cookie.SetCookie;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicClientCookie
  implements ClientCookie, SetCookie, Serializable, Cloneable
{
  private Map<String, String> attribs;
  private String cookieComment;
  private String cookieDomain;
  private Date cookieExpiryDate;
  private String cookiePath;
  private int cookieVersion;
  private boolean isSecure;
  private final String name;
  private String value;
  
  public BasicClientCookie(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    this.name = paramString1;
    this.attribs = new HashMap();
    this.value = paramString2;
  }
  
  public Object clone()
  {
    BasicClientCookie localBasicClientCookie = (BasicClientCookie)super.clone();
    localBasicClientCookie.attribs = new HashMap(this.attribs);
    return localBasicClientCookie;
  }
  
  public boolean containsAttribute(String paramString)
  {
    return this.attribs.get(paramString) != null;
  }
  
  public String getAttribute(String paramString)
  {
    return (String)this.attribs.get(paramString);
  }
  
  public String getDomain()
  {
    return this.cookieDomain;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.cookiePath;
  }
  
  public int[] getPorts()
  {
    return null;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int getVersion()
  {
    return this.cookieVersion;
  }
  
  public boolean isExpired(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("Date may not be null");
    }
    return (this.cookieExpiryDate != null) && (this.cookieExpiryDate.getTime() <= paramDate.getTime());
  }
  
  public boolean isSecure()
  {
    return this.isSecure;
  }
  
  public void setAttribute(String paramString1, String paramString2)
  {
    this.attribs.put(paramString1, paramString2);
  }
  
  public void setComment(String paramString)
  {
    this.cookieComment = paramString;
  }
  
  public void setDomain(String paramString)
  {
    if (paramString != null)
    {
      this.cookieDomain = paramString.toLowerCase(Locale.ENGLISH);
      return;
    }
    this.cookieDomain = null;
  }
  
  public void setExpiryDate(Date paramDate)
  {
    this.cookieExpiryDate = paramDate;
  }
  
  public void setPath(String paramString)
  {
    this.cookiePath = paramString;
  }
  
  public void setSecure(boolean paramBoolean)
  {
    this.isSecure = paramBoolean;
  }
  
  public void setVersion(int paramInt)
  {
    this.cookieVersion = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[version: ");
    localStringBuilder.append(Integer.toString(this.cookieVersion));
    localStringBuilder.append("]");
    localStringBuilder.append("[name: ");
    localStringBuilder.append(this.name);
    localStringBuilder.append("]");
    localStringBuilder.append("[value: ");
    localStringBuilder.append(this.value);
    localStringBuilder.append("]");
    localStringBuilder.append("[domain: ");
    localStringBuilder.append(this.cookieDomain);
    localStringBuilder.append("]");
    localStringBuilder.append("[path: ");
    localStringBuilder.append(this.cookiePath);
    localStringBuilder.append("]");
    localStringBuilder.append("[expiry: ");
    localStringBuilder.append(this.cookieExpiryDate);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BasicClientCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */