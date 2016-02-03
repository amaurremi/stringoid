package com.amazonaws.org.apache.http.cookie;

import java.util.Date;

public abstract interface Cookie
{
  public abstract String getDomain();
  
  public abstract String getName();
  
  public abstract String getPath();
  
  public abstract int[] getPorts();
  
  public abstract String getValue();
  
  public abstract int getVersion();
  
  public abstract boolean isExpired(Date paramDate);
  
  public abstract boolean isSecure();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */