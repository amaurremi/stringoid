package com.amazonaws.org.apache.http.cookie;

public abstract interface ClientCookie
  extends Cookie
{
  public abstract boolean containsAttribute(String paramString);
  
  public abstract String getAttribute(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/cookie/ClientCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */